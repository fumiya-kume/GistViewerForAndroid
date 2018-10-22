package com.example.gist.domain.repository

import com.example.gist.infra.repository.GistDetailRepositoryImpl
import org.koin.dsl.module.module

internal val repositoryModule = module {
  factory { GistDetailRepositoryImpl(get()) as GistDetailRepository }
}