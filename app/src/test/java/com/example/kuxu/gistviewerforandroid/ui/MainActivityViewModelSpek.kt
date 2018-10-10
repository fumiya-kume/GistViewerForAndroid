package com.example.kuxu.gistviewerforandroid.ui

import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.Mockito.*


internal class MainActivityViewModelSpek: KoinTest{

    @Test
    fun 画面が開かれた時にGithubのログイン画面を開く(){
        val chromeCustomTabsService  = mock(ChromeCustomTabsService::class.java)
        val viewModel = MainActivityViewModel(chromeCustomTabsService)

        viewModel.GithubLoginPage()

        verify(chromeCustomTabsService, times(1))
    }

}