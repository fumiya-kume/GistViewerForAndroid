package com.example.github_api.gist

import awaitStringResponse
import com.github.kittinunf.fuel.httpGet
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class CheckIfStaredGistImpl : CheckIfStaredGist {
  override fun StaredGistList(gistId: String): Single<Pair<String, Boolean>> =
    Single.fromCallable {
      runBlocking {
        val (_, response, _) = "/gists/$gistId/star".httpGet().awaitStringResponse()
        val checkResult = when (response.statusCode) {
          204 -> true
          else -> false
        }
        return@runBlocking gistId to checkResult
      }
    }
}