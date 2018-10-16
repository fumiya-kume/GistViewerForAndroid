package com.example.kuxu.gistviewerforandroid.ui.gist

import com.example.kuxu.gistviewerforandroid.ui.gist.overview.GistOverViewLiveDataFactory
import com.example.kuxu.gistviewerforandroid.ui.gist.overview.GistOverViewViewModel
import com.example.kuxu.gistviewerforandroid.ui.gist.post.GistEditorFragmentViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val gistModule = module {
  factory { GistOverViewLiveDataFactory(get()) }
  viewModel { GistOverViewViewModel(get(), get()) }

  // post
  viewModel { GistEditorFragmentViewModel(get()) }
}