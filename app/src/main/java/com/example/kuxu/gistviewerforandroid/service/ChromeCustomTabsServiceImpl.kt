package com.example.kuxu.gistviewerforandroid.service

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import org.koin.standalone.KoinComponent

internal class ChromeCustomTabsServiceImpl(
        private val context: Context
) : ChromeCustomTabsService, KoinComponent {
    override fun opneGithubLoginPage(clientId: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        val uri = Uri.parse("https://github.com/login/oauth/authorize?client_id=${clientId}")
        customTabsIntent.launchUrl(context, uri)
    }
}