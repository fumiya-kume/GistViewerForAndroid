package com.example.kuxu.gistviewerforandroid.ui

import androidx.lifecycle.ViewModel
import com.example.gist.domain.service.GithubLoginAtBrowserService
import com.example.prop.GithubProperties

internal class MainActivityViewModel(
  private val chromeCustomTabsService: GithubLoginAtBrowserService,
  private val githubProperties: GithubProperties
        ) : ViewModel() {
    fun GithubLoginPage() {
        val clientId = githubProperties.clientId
        chromeCustomTabsService.opneGithubLoginPage(clientId)
    }
}