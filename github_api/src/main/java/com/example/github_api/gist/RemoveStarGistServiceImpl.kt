package com.example.github_api.gist

import awaitStringResult
import com.github.kittinunf.fuel.httpDelete
import io.reactivex.Completable
import kotlinx.coroutines.experimental.runBlocking

internal class RemoveStarGistServiceImpl : RemoveStarGistService {
  override fun execute(targetGistId: String): Completable {
    return runBlocking {
      "/gists/$targetGistId/star".httpDelete().awaitStringResult()
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