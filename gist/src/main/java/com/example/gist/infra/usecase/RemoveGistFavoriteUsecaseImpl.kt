package com.example.gist.infra.usecase

import com.example.gist.domain.usecase.RemoveGistFavoriteUsecase
import com.example.github_api.gist.RemoveStarGistService
import io.reactivex.Completable

internal class RemoveGistFavoriteUsecaseImpl(
  private val removeStarGistService: RemoveStarGistService
): RemoveGistFavoriteUsecase {
  override fun execute(targetGistId: String): Completable = removeStarGistService.execute(targetGistId)
}