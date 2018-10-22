package com.example.gist.ui.viewer.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gist.databinding.ItemGistDetailFileViewBinding
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailFileBindingModel

internal class GistFileViewHolder private constructor(
  private val binding: ItemGistDetailFileViewBinding
) : RecyclerView.ViewHolder(binding.root) {
  companion object {
    fun create(
      inflater: LayoutInflater,
      parent: ViewGroup
    ): GistFileViewHolder =
      GistFileViewHolder(
        ItemGistDetailFileViewBinding.inflate(
          inflater,
          parent,
          false
        )
      )
  }

  fun bindTo(
    bindingModel: GistDetailFileBindingModel,
    onGistDetailClickListener: OnGistDetailClickListener?
  ) {
    binding.bindingModel = bindingModel
    binding.root.setOnClickListener {
      onGistDetailClickListener?.OnClick(bindingModel)
    }
  }
}