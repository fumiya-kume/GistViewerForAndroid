package com.example.kuxu.gistviewerforandroid.ui.gist

import com.example.github_api.gist.entity.Gist
import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel

internal object GistOverViewItemConverter {
  fun convertToBindingModel(gist: Gist): GistOverViewItemBindingModel = GistOverViewItemBindingModel(id = gist.id, gistTitle = gist.owner.login, createdDate = gist.createdAt)

  fun convertToBindingModel(gistList: List<Gist>): List<GistOverViewItemBindingModel> = gistList.map { convertToBindingModel(it) }
}