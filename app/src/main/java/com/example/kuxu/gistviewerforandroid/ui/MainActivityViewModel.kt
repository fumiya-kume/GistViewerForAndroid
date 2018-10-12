package com.example.kuxu.gistviewerforandroid.ui

import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import com.example.prop.GithubProperties

internal class MainActivityViewModel(
        private val chromeCustomTabsService: ChromeCustomTabsService,
        private val githubProperties: GithubProperties
        ) : ViewModel() {
    fun GithubLoginPage() {
        val clientId = githubProperties.clientId
        chromeCustomTabsService.opneGithubLoginPage(clientId)
    }
}