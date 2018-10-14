package com.example.prop

import com.example.prop.sercret.AccessTokenRepository
import com.example.prop.sercret.AccessTokenRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module


val propModule = module {
    factory { GithubPropertiesImpl() as GithubProperties }
    factory { AccessTokenRepositoryImpl(androidApplication()) as AccessTokenRepository }
}