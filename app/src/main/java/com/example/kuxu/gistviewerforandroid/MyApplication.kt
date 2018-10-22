package com.example.kuxu.gistviewerforandroid

import android.app.Application
import com.example.gist.gistModule
import com.example.github_api.githubServiceModule
import com.example.github_api.startGithubClient
import com.example.kuxu.gistviewerforandroid.domain.service.domainModule
import com.example.kuxu.gistviewerforandroid.ui.uiModule
import com.example.prop.propModule
import org.koin.android.ext.android.startKoin

internal class MyApplication : Application() {
  override fun onCreate() {
    super.onCreate()

    val mainActivityModule = uiModule + domainModule


    val modules =
      propModule +
        githubServiceModule +
        mainActivityModule +
        gistModule

    startKoin(
      this,
      modules
    )

    // startGithubClient is should after startKoin
    startGithubClient()
  }
}