package com.example.prop

import org.koin.dsl.module.module


val propModule = listOf(
  module {
    factory { GithubPropertiesImpl() as GithubProperties }
  }
)