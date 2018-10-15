package com.example.github_api.gist

import com.example.github_api.body
import com.example.github_api.gist.entity.GistPostData
import com.github.kittinunf.fuel.httpPost
import io.reactivex.Completable
import kotlinx.coroutines.experimental.runBlocking

internal class PostGistServiceImpl : PostGistService {
  override fun PostGist(postData: GistPostData): Completable =
    Completable.fromCallable {
      runBlocking {
        "gists".httpPost().body(postData).responseString().third
          .fold(
            success = {
              return@runBlocking
            },
            failure = {
              throw it.exception
            }
          )

      }
    }
}