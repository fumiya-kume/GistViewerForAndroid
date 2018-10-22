package com.example.gist.domain.usecase

import com.example.gist.infra.usecase.AddGistFavoriteUsecaseImpl
import com.example.gist.infra.usecase.RemoveGistFavoriteUsecaseImpl
import org.koin.dsl.module.module

internal val usecaseModule = module {
  factory { AddGistFavoriteUsecaseImpl(get()) as AddGistFavoriteUsecase }
  factory { RemoveGistFavoriteUsecaseImpl(get()) as RemoveGistFavoriteUsecase }
}