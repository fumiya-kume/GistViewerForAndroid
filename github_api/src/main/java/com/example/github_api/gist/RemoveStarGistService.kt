package com.example.github_api.gist

import io.reactivex.Completable

public interface RemoveStarGistService {
  fun execute(targetGistId: String): Completable
}