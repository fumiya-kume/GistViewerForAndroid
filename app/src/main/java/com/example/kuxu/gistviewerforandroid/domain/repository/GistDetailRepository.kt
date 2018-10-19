package com.example.kuxu.gistviewerforandroid.domain.repository

import com.example.github_api.gist.entity.Gist
import io.reactivex.Single

internal interface GistDetailRepository {
  fun loadGistDetail(gistId: String):Single<Gist>
}