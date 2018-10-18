package com.example.kuxu.gistviewerforandroid.domain

import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository
import com.example.kuxu.gistviewerforandroid.infra.repository.GistDetailRepositoryImpl
import org.koin.dsl.module.module

internal val domainModule = module {
  factory { GistDetailRepositoryImpl(get()) as GistDetailRepository }
}