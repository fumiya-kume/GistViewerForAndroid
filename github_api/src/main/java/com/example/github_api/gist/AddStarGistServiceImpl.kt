package com.example.github_api.gist

import awaitStringResult
import com.github.kittinunf.fuel.httpPut
import io.reactivex.Completable
import kotlinx.coroutines.experimental.runBlocking

internal class AddStarGistServiceImpl : AddStarGistService {
  override fun execute(targetGistId: String): Completable {
    return runBlocking {
      "/gists/$targetGistId/star".httpPut().awaitStringResult()
        .fold(
          success = {
            return@fold Completable.complete()
          },
          failure = {
            throw it.exception
          }
        )
    }
  }
}