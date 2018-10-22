package com.example.gist.ui.viewer.detail

import com.example.gist.domain.repository.GistDetailRepository

internal class GistDetailFileListLiveDataFactory(
  private val gistDetailRepository: GistDetailRepository
) {
  fun create(targetGistId: String): GistDetailFileListLiveData = GistDetailFileListLiveData(targetGistId, gistDetailRepository)
}