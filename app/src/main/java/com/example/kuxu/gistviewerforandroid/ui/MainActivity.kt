package com.example.kuxu.gistviewerforandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.github_api.GithubService
import com.example.kuxu.gistviewerforandroid.R
import com.example.kuxu.gistviewerforandroid.service.GithubAuthcationService
import com.example.prop.sercret.AccessTokenRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.runBlocking
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {

    val viewModel: MainActivityViewModel by viewModel()
    val githubAuthcationService: GithubAuthcationService by inject()
    val accessTokenRepository: AccessTokenRepository by inject()
    val githubService: GithubService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (intent.data == null) {
            viewModel.GithubLoginPage()
        }
        val uri = intent?.data
        uri?.apply {
            if (uri.toString().startsWith("gist-viewer")) {
                val queryResult = uri.getQueryParameter("code")
                message.text = queryResult
                var accessToken = ""
                runBlocking {
                    accessToken = githubAuthcationService.AuthWithAccessToken(queryResult).await()
                }
                accessTokenRepository.saveAccessToken(accessToken)

                message.text = "AccessToken:" + accessTokenRepository.loadAccessToken()

                githubService.updateAccessToken(accessToken)
                runBlocking {
                    val result = githubService.loadGistCount().await()
                    print(result)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }
}