package com.example.gist.ui.viewer.overview

import androidx.lifecycle.ViewModel
import com.example.gist.domain.service.ChromeCustomTabsService
import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel


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
