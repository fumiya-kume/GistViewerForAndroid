package com.example.kuxu.gistviewerforandroid.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import org.koin.standalone.KoinComponent

internal class MainActivityViewModel(
        private val chromeCustomTabsService: ChromeCustomTabsService
): ViewModel() {
    fun GithubLoginPage(){
        chromeCustomTabsService.opneGithubLoginPage("7425e12b01ace19dbbee")
    }
}
