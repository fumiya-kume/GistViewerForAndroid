package com.example.gist.ui.viewer.detail

import com.example.gist.ui.viewer.detail.bindingModel.GistDetailFileBindingModel

internal interface OnGistDetailClickListener {
  fun OnClick(bindingModel: GistDetailFileBindingModel)
}