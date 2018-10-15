package com.example.kuxu.gistviewerforandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.github_api.Auth.GithubAuthcationService
import com.example.github_api.User.UserInfomationDataStore
import com.example.github_api.sercret.AccessTokenRepository
import com.example.kuxu.gistviewerforandroid.HomeActivity
import com.example.kuxu.gistviewerforandroid.R
import io.reactivex.rxkotlin.subscribeBy
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {

  val viewModel: MainActivityViewModel by viewModel()
  val githubAuthcationService: GithubAuthcationService by inject()
  val accessTokenRepository: AccessTokenRepository by inject()
  val userInfomationDataStore: UserInfomationDataStore by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (!accessTokenRepository.loadAccessToken().isEmpty()) {
      userInfomationDataStore.userInfomation()
        .subscribeBy(
          onSuccess = {
            ShowErrorMessage("Welcome to ${it.userName} !!")
            navigateToHomeActivity()
          },
          onError = {
            ShowErrorMessage("認証で問題が発生しました")
          }
        )
    } else {
      viewModel.GithubLoginPage()
    }

    val uri = intent?.data
    uri?.apply {
      if (uri.toString().startsWith("gist-viewer")) {
        val queryResult = uri.getQueryParameter("code")
        queryResult?.let {
          githubAuthcationService.authWithCode(queryResult)
            .flatMap { accessTokenRepository.saveAccessToken(it) }
            .flatMap { userInfomationDataStore.userInfomation() }
            .subscribeBy(
              onSuccess = {
                ShowErrorMessage("Welcome to ${it.userName}")
                navigateToHomeActivity()
              },
              onError = {
                ShowErrorMessage("AccessToken を取得に失敗しました")
              }
            )
        }
      }
    }
  }

  private fun ShowErrorMessage(message: String) {
    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
  }

  private fun navigateToHomeActivity() {
    val intent = Intent(
      this,
      HomeActivity::class.java
    )
    startActivity(intent)
  }
}