package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository

internal class GistDetailFileListLiveDataFactory(
  private val gistDetailRepository: GistDetailRepository
) {
  fun create(targetGistId: String): GistDetailFileListLiveData = GistDetailFileListLiveData(targetGistId, gistDetailRepository)
}