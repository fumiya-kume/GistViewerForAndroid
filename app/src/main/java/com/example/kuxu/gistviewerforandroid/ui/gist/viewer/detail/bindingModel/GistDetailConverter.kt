package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel

import com.example.github_api.gist.entity.Gist

internal object GistDetailConverter {
  internal fun convert(gist: Gist) = GistDetailBindingModel(gist.id, gist.description ?: "")
}