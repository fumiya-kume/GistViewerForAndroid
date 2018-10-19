package com.example.kuxu.gistviewerforandroid.domain

import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository
import com.example.kuxu.gistviewerforandroid.domain.usecase.AddGistFavoriteUsecase
import com.example.kuxu.gistviewerforandroid.domain.usecase.RemoveGistFavoriteUsecase
import com.example.kuxu.gistviewerforandroid.infra.repository.GistDetailRepositoryImpl
import com.example.kuxu.gistviewerforandroid.infra.usecase.AddGistFavoriteUsecaseImpl
import com.example.kuxu.gistviewerforandroid.infra.usecase.RemoveGistFavoriteUsecaseImpl
import org.koin.dsl.module.module

internal val domainModule = module {
  factory { GistDetailRepositoryImpl(get()) as GistDetailRepository }

  // usecase
  factory { AddGistFavoriteUsecaseImpl(get()) as AddGistFavoriteUsecase }
  factory { RemoveGistFavoriteUsecaseImpl(get()) as RemoveGistFavoriteUsecase }
}