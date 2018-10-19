package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import androidx.lifecycle.ViewModel

internal class GistDetailViewFragmentViewModel(
  private val targetGistId: String,
  private val gistInfoamtionLiveDataFactory: GistDetailLiveDataFactory,
  private val gistDetailFileListLiveDataFactory: GistDetailFileListLiveDataFactory
) : ViewModel() {
  val gistDetailLiveData: GistDetailLiveData = gistInfoamtionLiveDataFactory.create(targetGistId)
  val gistDetailFileListLiveData: GistDetailFileListLiveData = gistDetailFileListLiveDataFactory.create(targetGistId)
}