package com.example.kuxu.gistviewerforandroid.ui.gist.overview.bindingModel

internal data class GistOverViewItemBindingModel(
  val id: String,
  val gistTitle: String?,
  val description: String?,
  val gistUrl: String?,
  val favorite: Boolean
)