package com.example.gist.ui.post

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val postModule = module {
  factory { GistFileLiveDataFactory() }
  viewModel { GistEditorFragmentViewModel(get(), get()) }
}