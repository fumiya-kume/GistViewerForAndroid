package com.example.gist.domain.service.serviceimpl

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import com.example.gist.domain.service.ChromeCustomTabsService
import org.koin.standalone.KoinComponent

internal class ChromeCustomTabsServiceImpl(
  private val context: Context
) : ChromeCustomTabsService, KoinComponent {
  override fun OpenChrome(url: String) {
    open(url)
  }

  private fun open(url: String) {
    val customTabsIntent = CustomTabsIntent.Builder().build()
    val uri = url.toUri()
    customTabsIntent.launchUrl(context, uri)
  }
}