package com.example.kuxu.gistviewerforandroid.ui

import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import com.example.prop.GithubProperties
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito.*


internal class MainActivityViewModelSpek : KoinTest {
    @Test
    fun 画面が開かれた時にGithubのログイン画面を開く() {
        val chromeCustomTabsService = mock(ChromeCustomTabsService::class.java)
        val githubProperties = mock(GithubProperties::class.java)
        val viewModel = MainActivityViewModel(chromeCustomTabsService, githubProperties)

        viewModel.GithubLoginPage()

        verify(chromeCustomTabsService, times(1))
    }
}