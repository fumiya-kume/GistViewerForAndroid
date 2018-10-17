package com.example.kuxu.gistviewerforandroid.ui.gist.post.bindingModel

internal data class GistEditorFileBindingModel(
  // File はユニーク
  val fileName: String,
  val content: String
)