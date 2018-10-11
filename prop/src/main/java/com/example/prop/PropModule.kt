package com.example.prop

import org.koin.dsl.module.module

val propModule = module {
    single { GithubPropertiesImpl() as GithubProperties }
}