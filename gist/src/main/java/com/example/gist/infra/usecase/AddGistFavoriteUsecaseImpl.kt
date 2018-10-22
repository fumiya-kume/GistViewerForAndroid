package com.example.gist.infra.usecase

import com.example.gist.domain.usecase.AddGistFavoriteUsecase
import com.example.github_api.gist.AddStarGistService
import io.reactivex.Completable

internal class AddGistFavoriteUsecaseImpl(
  private val  addStarGistService: AddStarGistService
): AddGistFavoriteUsecase {
  override fun execute(targetGistId: String): Completable = addStarGistService.execute(targetGistId)
}