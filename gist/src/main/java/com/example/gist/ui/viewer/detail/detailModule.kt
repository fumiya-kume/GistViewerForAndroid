package com.example.gist.ui.viewer.detail

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val detailModule = module {
  factory { GistDetailLiveDataFactory(get(), get()) }
  viewModel { (targetGistId: String) -> GistDetailViewFragmentViewModel(targetGistId, get(), get(), get(), get(), get()) }
  factory { GistDetailFileListLiveDataFactory(get()) }
}