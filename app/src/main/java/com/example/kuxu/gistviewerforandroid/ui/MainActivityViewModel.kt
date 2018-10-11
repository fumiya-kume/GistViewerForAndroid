package com.example.kuxu.gistviewerforandroid.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.BuildConfig
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import com.example.prop.GithubProperties
import org.koin.standalone.KoinComponent

internal class MainActivityViewModel(
        private val chromeCustomTabsService: ChromeCustomTabsService,
        private val githubProperties: GithubProperties
): ViewModel() {
    fun GithubLoginPage(){
        val clientId = githubProperties.clientId
        chromeCustomTabsService.opneGithubLoginPage(clientId)
    }
}
