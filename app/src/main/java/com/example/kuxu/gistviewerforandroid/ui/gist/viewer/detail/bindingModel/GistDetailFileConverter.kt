package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel

import com.example.github_api.gist.entity.File
import com.example.github_api.gist.entity.Gist

internal object GistDetailFileConverter {
  private fun convert(gist: Gist, file: File) = GistDetailFileBindingModel(gist.id, "${gist.owner.login} / ${file.fileName}", file.language?:"", "${file.size} B")

  fun convert(gist: Gist): List<GistDetailFileBindingModel> = gist.files.map { convert(gist, it.value) }
}