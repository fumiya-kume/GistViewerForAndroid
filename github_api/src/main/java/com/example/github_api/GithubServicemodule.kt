package com.example.github_api

import com.example.github_api.domain.domainModule
import com.example.github_api.infra.infraModule

public val githubServiceModule = listOf(
        infraModule,
        domainModule
)