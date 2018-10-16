package com.example.github_api.gist

import io.reactivex.Single

public interface CheckIfStaredGist {
  fun StaredGistList(gistId: String): Single<Map<String, Boolean>>
}