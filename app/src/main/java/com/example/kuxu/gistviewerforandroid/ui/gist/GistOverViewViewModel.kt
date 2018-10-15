package com.example.kuxu.gistviewerforandroid.ui.gist

import androidx.lifecycle.ViewModel

internal class GistOverViewViewModel(
  private val gistOverViewLiveDataFactory: GistOverViewLiveDataFactory
): ViewModel() {
  val gistOverViewLiveData = gistOverViewLiveDataFactory.create()
}
