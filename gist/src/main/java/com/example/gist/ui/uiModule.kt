package com.example.gist.ui

import com.example.gist.ui.post.postModule
import com.example.gist.ui.viewer.detail.detailModule
import com.example.gist.ui.viewer.overview.overviewModule

internal val uiModule = listOf(
  overviewModule,
  detailModule,
  postModule
)