package com.example.gist.ui.viewer.detail.bindingModel

internal data class GistDetailBindingModel(
  val id: String,
  val gistName: String,
  val createdDate: String,
  val gistSize: String,
  val ownerName: String,
  val ownerProfileImageUrl: String,
  val favorite: Boolean
)