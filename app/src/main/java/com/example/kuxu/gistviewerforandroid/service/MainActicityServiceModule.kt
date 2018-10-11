package com.example.kuxu.gistviewerforandroid.service

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val serviceModule = module {
    factory { ChromeCustomTabsServiceImpl(androidApplication()) as ChromeCustomTabsService }

    single { GithubAuthcationServiceImpl(get()) as GithubAuthcationService }
}