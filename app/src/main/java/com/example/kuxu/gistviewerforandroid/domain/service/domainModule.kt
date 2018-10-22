package com.example.kuxu.gistviewerforandroid.domain.service

import com.example.gist.domain.service.GithubLoginAtBrowserService
import com.example.gist.domain.service.serviceimpl.GithubLoginAtBrowserServiceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

internal val domainModule = listOf(
  module {
    factory { GithubLoginAtBrowserServiceImpl(androidApplication()) as GithubLoginAtBrowserService }
  }
)