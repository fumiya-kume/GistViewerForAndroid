package com.example.kuxu.gistviewerforandroid.infra.usecase

import com.example.github_api.gist.AddStarGistService
import com.example.kuxu.gistviewerforandroid.domain.usecase.AddGistFavoriteUsecase
import io.reactivex.Completable

internal class AddGistFavoriteUsecaseImpl(
  private val  addStarGistService: AddStarGistService
):AddGistFavoriteUsecase{
  override fun execute(targetGistId: String): Completable = addStarGistService.execute(targetGistId)
}