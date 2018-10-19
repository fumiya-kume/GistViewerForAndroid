package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import com.example.github_api.gist.CheckIfStaredGist
import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository

internal class GistDetailLiveDataFactory(
  private val gistDetailRepository: GistDetailRepository,
  private val checkIfStaredGist: CheckIfStaredGist
) {
  fun create(targetGistId: String): GistDetailLiveData = GistDetailLiveData(targetGistId, gistDetailRepository,checkIfStaredGist)
}