package com.example.github_api.gist

import com.example.github_api.awaitResultObject
import com.example.github_api.gist.entity.Gist
import com.github.kittinunf.fuel.httpGet
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class GetSpecificGistImpl : GetSpecificGist {
  override fun loadSpecificGist(targetGistId: String): Single<Gist> = Single.fromCallable {
    runBlocking {
      "/gists/$targetGistId".httpGet().awaitResultObject<Gist>().await()
        .fold(
          success = {
            return@runBlocking it as Gist
          },
          failure = {
            throw it.exception
          }
        )
    }
  }
}