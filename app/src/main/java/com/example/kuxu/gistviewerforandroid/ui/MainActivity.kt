package com.example.kuxu.gistviewerforandroid.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.github_api.domain.GithubAuthcationService
import com.example.github_api.domain.UserInfomationRepository
import com.example.github_api.infra.GithubServiceSetting
import com.example.kuxu.gistviewerforandroid.HomeActivity
import com.example.kuxu.gistviewerforandroid.R
import com.example.prop.sercret.AccessTokenRepository
import io.reactivex.rxkotlin.subscribeBy
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {

  val viewModel: MainActivityViewModel by viewModel()
  val githubAuthcationService: GithubAuthcationService by inject()
  val accessTokenRepository: AccessTokenRepository by inject()
  val githubServiceSetting: GithubServiceSetting by inject()
  val userInfomationRepository: UserInfomationRepository by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (intent.data == null) {
      viewModel.GithubLoginPage()
    }

    userInfomationRepository.userInfomation()
      .subscribeBy(
        onSuccess = {
          print(it.name)
        }
      )


    if (!accessTokenRepository.loadAccessToken().isEmpty()) {
      navigateToHomeActivity()
    }

    val uri = intent?.data
    uri?.apply {
      if (uri.toString().startsWith("gist-viewer")) {
        val queryResult = uri.getQueryParameter("code")
        queryResult?.let {
          githubAuthcationService.AuthWithCode(queryResult)
            .subscribeBy(
              onSuccess = {
                githubServiceSetting.updateAccessToken(it)
                  .subscribeBy(
                    onComplete = {
                      userInfomationRepository.userInfomation()
                        .subscribeBy(
                          onSuccess = {
                            ShowErrorMessage(it.name)
                            navigateToHomeActivity()
                          },
                          onError = {
                            ShowErrorMessage("Can not get user infomation")
                          }
                        )
                    },
                    onError = {
                      ShowErrorMessage("Missing Authcation")
                    }
                  )

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