package com.example.github_api.gist

import awaitStringResponse
import com.github.kittinunf.fuel.httpGet
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class CheckIfStaredGistImpl : CheckIfStaredGist {
  override fun StaredGistList(gistId: String): Single<Map<String, Boolean>> =
    Single.fromCallable {
      runBlocking {
        val response = "/gists/$gistId/star".httpGet().awaitStringResponse()
        response.third.fold(
          success = {
            // 200番台はスターしてる状態、それ以外はスターしてないと判定
            val stared = response.second.statusCode == 2
            return@runBlocking mapOf(gistId to stared)
          },
          failure = {
            throw it.exception
          }
        )
      }
    }
}