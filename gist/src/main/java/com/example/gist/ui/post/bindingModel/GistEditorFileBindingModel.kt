package com.example.gist.ui.post.bindingModel

internal data class GistEditorFileBindingModel(
  // File はユニーク
  val fileName: String,
  val content: String
)