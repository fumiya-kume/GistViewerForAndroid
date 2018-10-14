package com.example.kuxu.gistviewerforandroid.ui

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

internal val uiModule = module {
    viewModel {
        MainActivityViewModel(get(), get())
    }
}