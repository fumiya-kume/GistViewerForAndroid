package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview

import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.bindingModel.GistOverViewItemBindingModel

internal interface OnClickGistListener {
  fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel)
}