package com.example.gist.ui.viewer.detail

import com.example.github_api.gist.CheckIfStaredGist
import com.example.gist.domain.repository.GistDetailRepository

internal class GistDetailLiveDataFactory(
  private val gistDetailRepository: GistDetailRepository,
  private val checkIfStaredGist: CheckIfStaredGist
) {
  fun create(targetGistId: String): GistDetailLiveData = GistDetailLiveData(targetGistId, gistDetailRepository,checkIfStaredGist)
}