package com.example.kuxu.gistviewerforandroid.ui.gist

import com.example.github_api.gist.entity.Gist
import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel

internal object GistOverViewItemConverter {

  private fun description(gist: Gist) = "📁${gist.files.count()} 📝${gist.comments}"

  fun convertToBindingModel(gist: Gist): GistOverViewItemBindingModel = GistOverViewItemBindingModel(id = gist.id, gistTitle = "${gist.owner.login} / ${gist.files.keys.first()}", description = description(gist))

  fun convertToBindingModel(gistList: List<Gist>): List<GistOverViewItemBindingModel> = gistList.map { convertToBindingModel(it) }
}