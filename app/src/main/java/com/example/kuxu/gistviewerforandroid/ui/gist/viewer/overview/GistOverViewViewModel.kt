package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview

import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.bindingModel.GistOverViewItemBindingModel

internal class GistOverViewViewModel(
  gistOverViewLiveDataFactory: GistOverViewLiveDataFactory,
  private val chromeCustomTabsService: ChromeCustomTabsService
) : ViewModel() {
  val gistOverViewLiveData = gistOverViewLiveDataFactory.create()

  fun onclickGistItem(
    gistOverViewItemBindingModel: GistOverViewItemBindingModel
  ) {
    gistOverViewItemBindingModel.gistUrl?.let {
      chromeCustomTabsService.OpenChrome(url = gistOverViewItemBindingModel.gistUrl)
    }
  }
}
