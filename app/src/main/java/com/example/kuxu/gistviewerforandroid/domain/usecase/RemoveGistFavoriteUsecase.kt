package com.example.kuxu.gistviewerforandroid.domain.usecase

import io.reactivex.Completable

internal interface RemoveGistFavoriteUsecase {
  fun execute(targetGistId: String): Completable
}