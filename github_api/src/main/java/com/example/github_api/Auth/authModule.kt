package com.example.github_api.Auth

import org.koin.dsl.module.module

internal val authModule = module {
  single { GithubAuthcationServiceImpl(get()) as GithubAuthcationService }
}