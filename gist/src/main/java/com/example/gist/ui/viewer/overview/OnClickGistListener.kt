package com.example.gist.ui.viewer.overview

import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel

internal interface OnClickGistListener {
  fun onClick(gistOverViewItemBindingModel: GistOverViewItemBindingModel)
}