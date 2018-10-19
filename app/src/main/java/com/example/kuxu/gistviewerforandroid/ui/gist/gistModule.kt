package com.example.kuxu.gistviewerforandroid.ui.gist

import com.example.kuxu.gistviewerforandroid.ui.gist.post.viewer.GistEditorFragmentViewModel
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.GistDetailFileListLiveDataFactory
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.GistDetailLiveDataFactory
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.GistDetailViewFragmentViewModel
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.GistOverViewLiveDataFactory
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.GistOverViewViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val gistModule = module {
  // Viewer/overView
  factory { GistOverViewLiveDataFactory(get(), get()) }
  viewModel { GistOverViewViewModel(get(), get()) }

  // Viewer/ Detail
  factory { GistDetailLiveDataFactory(get(), get()) }
  viewModel { (targetGistId: String) -> GistDetailViewFragmentViewModel(targetGistId, get(), get(), get(),get(),get()) }
  factory { GistDetailFileListLiveDataFactory(get()) }

  // post
  viewModel { GistEditorFragmentViewModel(get(), get()) }
}