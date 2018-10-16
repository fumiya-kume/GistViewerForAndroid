package com.example.github_api.gist

import com.example.github_api.awaitResultObject
import com.example.github_api.gist.entity.Gist
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class AuthzedUserGistDataStoreImpl : AuthzedUserGistDataStore {
  override fun loadGistList(): Single<List<Gist>> =
    Single.fromCallable {
      class GistListDeserializer : ResponseDeserializable<List<Gist>> {

        override fun deserialize(content: String): List<Gist>? {
          val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
          val type = Types.newParameterizedType(List::class.java, Gist::class.java)
          val listAdapter: JsonAdapter<List<Gist>> = moshi.adapter(type)
          return listAdapter.fromJson(content)
        }
      }

      runBlocking {
        "gists".httpGet().awaitResultObject(GistListDeserializer()).await()
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