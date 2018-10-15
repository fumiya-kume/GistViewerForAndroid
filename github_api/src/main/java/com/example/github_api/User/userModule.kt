package com.example.github_api.User

import org.koin.dsl.module.module

internal val usermodule = module {
  factory { UserInfomationDataStoreImpl() as UserInfomationDataStore }
}