package com.example.gist.infra.repository

import com.example.gist.domain.repository.GistDetailRepository
import com.example.github_api.gist.GetSpecificGist
import com.example.github_api.gist.entity.Gist
import io.reactivex.Single

internal class GistDetailRepositoryImpl(
  private val getSpecificGist: GetSpecificGist
) : GistDetailRepository {
  // できたらやること: Room を使って一度取得したデータのキャッシュ化
  override fun loadGistDetail(gistId: String): Single<Gist> = getSpecificGist.loadSpecificGist(gistId)
}