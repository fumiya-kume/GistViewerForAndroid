package com.example.github_api

import org.koin.dsl.module.module

public val githubServiceModule = module {
    single { GithubServiceImpl() as GithubService }
}