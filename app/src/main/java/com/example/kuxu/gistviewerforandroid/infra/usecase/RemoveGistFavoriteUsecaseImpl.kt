package com.example.kuxu.gistviewerforandroid.infra.usecase

import com.example.github_api.gist.RemoveStarGistService
import com.example.kuxu.gistviewerforandroid.domain.usecase.RemoveGistFavoriteUsecase
import io.reactivex.Completable

internal class RemoveGistFavoriteUsecaseImpl(
  private val removeStarGistService: RemoveStarGistService
): RemoveGistFavoriteUsecase{
  override fun execute(targetGistId: String): Completable = removeStarGistService.execute(targetGistId)
}