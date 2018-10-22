package com.example.gist.ui.viewer.detail.bindingModel

internal data class GistDetailFileBindingModel(
  val id: String,
  val title: String,
  val textType: String,
  val fileSize: String,
  val fileUrl: String
)