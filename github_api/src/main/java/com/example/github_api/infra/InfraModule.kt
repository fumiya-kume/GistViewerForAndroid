package com.example.github_api.infra

import org.koin.dsl.module.module

public val infraModule = module {
    factory { GithubServiceImpl(get()) as GithubService }
    factory { GithubServiceImpl(get()) as GithubServiceSetting }
}