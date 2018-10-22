package com.example.gist.domain

import com.example.gist.domain.repository.repositoryModule
import com.example.gist.domain.service.serviceModule
import com.example.gist.domain.usecase.usecaseModule

internal val domainModule = listOf(
  repositoryModule,
  usecaseModule,
  serviceModule
)