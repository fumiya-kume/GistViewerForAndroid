package com.example.kuxu.gistviewerforandroid.infra.repository

import com.example.github_api.gist.entity.Gist
import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository
import io.reactivex.Single

internal class GistDetailRepositoryImpl : GistDetailRepository {
  // できたらやること: Room を使って一度取得したデータのキャッシュ化
  override fun loadGistDetail(gistId: String): Single<Gist> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}