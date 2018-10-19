package com.example.github_api.gist

import io.reactivex.Completable

public interface AddStarGistService {
  fun execute(targetGistId: String): Completable
}