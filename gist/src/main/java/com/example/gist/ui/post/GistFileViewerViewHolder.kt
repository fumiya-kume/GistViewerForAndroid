package com.example.gist.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gist.databinding.ItemGistFileViewBinding
import com.example.gist.ui.post.bindingModel.GistFileViewBindingModel

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
    binding.executePendingBindings()
  }
}
