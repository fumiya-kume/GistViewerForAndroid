package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService

internal class GistDetailViewFragmentViewModel(
  private val targetGistId: String,
  private val gistInfoamtionLiveDataFactory: GistDetailLiveDataFactory,
  private val gistDetailFileListLiveDataFactory: GistDetailFileListLiveDataFactory,
  private val chromeCustomTabsService: ChromeCustomTabsService
) : ViewModel() {
  val gistDetailLiveData: GistDetailLiveData = gistInfoamtionLiveDataFactory.create(targetGistId)
  val gistDetailFileListLiveData: GistDetailFileListLiveData = gistDetailFileListLiveDataFactory.create(targetGistId)

  fun OpenGistFileOnBrowser(rawUrl: String){
    chromeCustomTabsService.OpenChrome(rawUrl)
  }
}