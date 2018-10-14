package com.example.github_api.domain

import com.example.github_api.infra.GithubServiceImpl
import com.example.github_api.infra.domain.UserInfomationRepositoryImpl
import org.koin.dsl.module.module

internal val domainModule = module {
  factory { UserInfomationRepositoryImpl() as UserInfomationRepository }
  factory { GithubServiceImpl(get()) as GithubService }
}