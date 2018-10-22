package com.example.gist.domain.usecase

import io.reactivex.Completable

internal interface AddGistFavoriteUsecase {
  fun execute(targetGistId: String): Completable
}