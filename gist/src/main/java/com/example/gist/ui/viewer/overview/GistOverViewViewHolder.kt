package com.example.gist.ui.viewer.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gist.databinding.ItemGistOverViewBinding
import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel


internal class GistOverViewViewHolder(
  private val binding: ItemGistOverViewBinding
) : RecyclerView.ViewHolder(binding.root) {
  companion object {
    fun create(
      inflater: LayoutInflater,
      parent: ViewGroup?,
      attachToRoot: Boolean
    ) = GistOverViewViewHolder(
      ItemGistOverViewBinding.inflate(
        inflater,
        parent,
        attachToRoot
      )
    )
  }

  fun bindTo(
    bindingModel: GistOverViewItemBindingModel,
    onClickGistListener: OnClickGistListener?
  ) {
    binding.bindingModel = bindingModel
    binding.root.setOnClickListener {
      onClickGistListener?.onClick(bindingModel)
    }
    binding.executePendingBindings()
  }
}