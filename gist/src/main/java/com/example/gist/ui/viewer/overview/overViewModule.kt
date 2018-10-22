package com.example.gist.ui.viewer.overview

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val overviewModule = module {
  viewModel { GistOverViewViewModel(get(), get()) }
  factory { GistOverViewLiveDataFactory(get(), get()) }
}