package com.example.gist.domain.service.serviceimpl

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import com.example.gist.domain.service.GithubLoginAtBrowserService
import org.koin.standalone.KoinComponent

internal class GithubLoginAtBrowserServiceImpl(
  private val context: Context
) : GithubLoginAtBrowserService, KoinComponent {

  override fun opneGithubLoginPage(clientId: String) {
    val customTabsIntent = CustomTabsIntent.Builder().build()
    val uri = Uri.parse("https://github.com/login/oauth/authorize?scope=gist&client_id=${clientId}")
    customTabsIntent.launchUrl(context, uri)
  }
}