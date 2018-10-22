package com.example.kuxu.gistviewerforandroid.ui

import com.example.gist.domain.service.GithubLoginAtBrowserService
import com.example.prop.GithubProperties
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito.*


internal class MainActivityViewModelSpek : KoinTest {

    @Test
    fun 画面が開かれた時にGithubのログイン画面を開く() {
        val chromeCustomTabsService = mock(GithubLoginAtBrowserService::class.java)
        val githubProperties = mock(GithubProperties::class.java)
        val viewModel = MainActivityViewModel(chromeCustomTabsService, githubProperties)

        `when`(githubProperties.clientId).thenReturn("hello")

        viewModel.GithubLoginPage()

        verify(chromeCustomTabsService, times(1))
    }
}