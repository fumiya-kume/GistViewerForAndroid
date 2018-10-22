package com.example.gist.ui.viewer.overview

import androidx.lifecycle.ViewModel


internal class GistOverViewViewModel(
  private val gistOverViewLiveDataFactory: GistOverViewLiveDataFactory
) : ViewModel() {

  val gistOverViewLiveData = gistOverViewLiveDataFactory.create()

  fun refreshItem() {
    gistOverViewLiveData.refreshGistList()
  }
}
