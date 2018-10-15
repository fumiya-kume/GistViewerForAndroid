package com.example.kuxu.gistviewerforandroid.ui.gist

import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel

internal interface OnClickGistListener {
  fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel)
}