package com.example.github_api.sercret

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

internal val sercretModule = module {
  factory { AccessTokenRepositoryImpl(androidApplication()) as AccessTokenRepository }
}