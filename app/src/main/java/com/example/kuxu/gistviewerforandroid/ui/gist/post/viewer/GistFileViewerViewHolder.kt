package com.example.kuxu.gistviewerforandroid.ui.gist.post.viewer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuxu.gistviewerforandroid.databinding.ItemGistFileViewBinding
import com.example.kuxu.gistviewerforandroid.ui.gist.post.bindingModel.GistFileViewBindingModel

internal class GistFileViewerViewHolder(
  private val binding: ItemGistFileViewBinding
) : RecyclerView.ViewHolder(binding.root) {
  companion object {
    fun create(
      inflater: LayoutInflater,
      parent: ViewGroup
    ): GistFileViewerViewHolder =
      GistFileViewerViewHolder(
        ItemGistFileViewBinding.inflate(
          inflater,
          parent,
          false
        )
      )
  }

  fun bindTo(
    bindingModel: GistFileViewBindingModel
  ) {
    binding.bindingModel = bindingModel
  }
}
