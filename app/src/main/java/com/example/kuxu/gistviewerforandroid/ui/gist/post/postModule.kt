package com.example.kuxu.gistviewerforandroid.ui.gist.post

import org.koin.dsl.module.module

internal val postModule = module {
  factory { GistFileLiveDataFactory() }

}