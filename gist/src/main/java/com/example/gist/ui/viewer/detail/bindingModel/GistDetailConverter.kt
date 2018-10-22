package com.example.gist.ui.viewer.detail.bindingModel

import com.example.github_api.gist.entity.Gist

internal object GistDetailConverter {

  fun gistTitle(gist: Gist): String =
    if (gist.description != null && !gist.description.isNullOrEmpty()) {
      gist.description!!
    } else if (gist.files.isNotEmpty() && gist.files.any { it.key.isNotEmpty() }) {
      gist.files.filter { it.key.isNotEmpty() }.map { it.key }.first()
    } else {
      ""
    }

  internal fun convert(gist: Gist) =
    GistDetailBindingModel(
      gist.id,
      gistTitle(gist),
      gist.createdAt.toString(),
      gist.files.map { it.value.size }.reduce { acc, i -> acc + i }.toString(),
      gist.owner.login,
      gist.owner.avatarUrl,
      false
    )
}