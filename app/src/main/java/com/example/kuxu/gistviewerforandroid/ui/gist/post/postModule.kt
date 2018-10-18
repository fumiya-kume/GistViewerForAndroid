package com.example.kuxu.gistviewerforandroid.ui.gist.post

import com.example.kuxu.gistviewerforandroid.ui.gist.post.viewer.GistFileLiveDataFactory
import org.koin.dsl.module.module

internal val postModule = module {
  factory { GistFileLiveDataFactory() }

}