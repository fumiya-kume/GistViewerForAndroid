package com.example.gist.ui.viewer.overview

import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel
import com.example.github_api.gist.entity.Gist

internal object GistOverViewItemConverter {

  private fun description(gist: Gist) = "📁${gist.files.count()} 📝${gist.comments}"

  private fun gistTitle(gist: Gist) = "${gist.owner.login} / ${gist.files.keys.first()}"

  fun convertToBindingModel(gist: Gist): GistOverViewItemBindingModel =
    GistOverViewItemBindingModel(
      id = gist.id ?: "",
      gistTitle = gistTitle(gist),
      description = description(gist),
      gistUrl = gist.htmlUrl,
      favorite = false
    )

  fun convertToBindingModel(gistList: List<Gist>): List<GistOverViewItemBindingModel> = gistList.map { convertToBindingModel(it) }
}