package com.example.github_api.gist

import com.example.github_api.awaitResultObject
import com.example.github_api.gist.entity.Gist
import com.github.kittinunf.fuel.httpGet
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class AuthzedUserGistDataStoreImpl : AuthzedUserGistDataStore {
  override fun loadGistList(): Single<List<Gist>> =
    Single.fromCallable {
      runBlocking {
        "gists".httpGet().awaitResultObject<List<Gist>>().await()
          .fold(
            success = {
              return@runBlocking it
            },
            failure = {
              throw it.exception
            }
          )
      }
    }
}