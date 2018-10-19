package com.example.kuxu.gistviewerforandroid.domain.usecase

import io.reactivex.Completable

internal interface AddGistFavoriteUsecase {
  fun execute(targetGistId: String): Completable
}