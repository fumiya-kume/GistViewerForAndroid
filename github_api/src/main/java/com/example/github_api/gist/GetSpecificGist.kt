package com.example.github_api.gist

import com.example.github_api.gist.entity.Gist
import io.reactivex.Single

public interface GetSpecificGist {
  fun loadSpecificGist(targetGistId: String): Single<Gist>
}