package com.example.github_api.gist

import awaitStringResponse
import com.example.github_api.body
import com.example.github_api.gist.entity.GistPostData
import com.github.kittinunf.fuel.httpPost
import io.reactivex.Completable
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

internal class PostGistServiceImpl : PostGistService {
  override fun PostGist(postData: GistPostData): Completable =
    Completable.fromCallable {
      GlobalScope.launch {
        "gists".httpPost().body(postData).awaitStringResponse().third
          .fold(
            success = {
              return@launch
            },
            failure = {
              throw it.exception
            }
          )
      }
    }
}