package com.example.kuxu.gistviewerforandroid.infra

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

internal val infraModule = module {
    factory { AccessTokenRepositoryImpl(androidApplication()) as AccessTokenRepository }
}