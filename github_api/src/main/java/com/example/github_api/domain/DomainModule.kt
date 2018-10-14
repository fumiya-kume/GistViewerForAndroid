package com.example.github_api.domain

import com.example.github_api.infra.domain.UserInfomationRepositoryImpl
import org.koin.dsl.module.module

public val domainModule = module {
    factory { UserInfomationRepositoryImpl() as UserInfomationRepository }
}