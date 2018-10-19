package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel.GistDetailFileBindingModel

internal interface OnGistDetailClickListener {
  fun OnClick(bindingModel: GistDetailFileBindingModel)
}