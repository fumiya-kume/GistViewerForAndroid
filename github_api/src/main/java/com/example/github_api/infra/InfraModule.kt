package com.example.github_api.infra

import org.koin.dsl.module.module

internal val infraModule = module {
  factory { GithubServiceImpl(get()) as GithubServiceSetting }
}