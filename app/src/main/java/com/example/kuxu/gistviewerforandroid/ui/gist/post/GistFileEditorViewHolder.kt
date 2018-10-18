package com.example.kuxu.gistviewerforandroid.ui.gist.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kuxu.gistviewerforandroid.databinding.ItemGistFileEditorViewBinding
import com.example.kuxu.gistviewerforandroid.ui.gist.post.bindingModel.GistEditorFileBindingModel

internal class GistFileEditorViewHolder(
  private val binding: ItemGistFileEditorViewBinding
) : RecyclerView.ViewHolder(binding.root) {
  companion object {
    fun create(
      inflater: LayoutInflater,
      parent: ViewGroup
    ): GistFileEditorViewHolder =
      GistFileEditorViewHolder(
        ItemGistFileEditorViewBinding.inflate(
          inflater,
          parent,
          false
        ))
  }

  fun bindTo(bindingModel: GistEditorFileBindingModel) {
    binding.bindingModel = bindingModel
  }
}