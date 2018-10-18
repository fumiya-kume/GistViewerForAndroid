package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import androidx.lifecycle.ViewModel

internal class GistDetailViewFragmentViewModel(
  private val targetGistId: String,
  private val gistInfoamtionLiveDataFactory: GistDetailLiveDataFactory
) : ViewModel() {
  val gistDetailLiveData: GistDetailLiveData = gistInfoamtionLiveDataFactory.create(targetGistId)
}