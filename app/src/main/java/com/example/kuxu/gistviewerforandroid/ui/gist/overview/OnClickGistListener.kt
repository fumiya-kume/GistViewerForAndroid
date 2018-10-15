package com.example.kuxu.gistviewerforandroid.ui.gist.overview

import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel

internal interface OnClickGistListener {
  fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel)
}