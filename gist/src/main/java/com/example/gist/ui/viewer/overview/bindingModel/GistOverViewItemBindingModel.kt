package com.example.gist.ui.viewer.overview.bindingModel

internal data class GistOverViewItemBindingModel(
  val id: String,
  val gistTitle: String?,
  val description: String?,
  val gistUrl: String?,
  val favorite: Boolean
)