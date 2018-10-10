package com.example.kuxu.gistviewerforandroid.ui

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val uiModule = module {
    viewModel { MainActivityViewModel(get()) }
}