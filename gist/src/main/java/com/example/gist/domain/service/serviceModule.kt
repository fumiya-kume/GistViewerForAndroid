package com.example.gist.domain.service

import com.example.gist.domain.service.serviceimpl.ChromeCustomTabsServiceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

internal val serviceModule = module {
  factory { ChromeCustomTabsServiceImpl(androidApplication()) as ChromeCustomTabsService }
}