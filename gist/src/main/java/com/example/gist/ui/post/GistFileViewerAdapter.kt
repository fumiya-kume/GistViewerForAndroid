package com.example.gist.ui.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.gist.ui.post.bindingModel.GistFileViewBindingModel


internal class GistFileViewerAdapter(
  private val context: Context
) : ListAdapter<GistFileViewBindingModel, GistFileViewerViewHolder>(ITEM_CALL_BACK) {
  companion object {
    private val ITEM_CALL_BACK = object : DiffUtil.ItemCallback<GistFileViewBindingModel>() {

      override fun areItemsTheSame(
        oldItem: GistFileViewBindingModel,
        newItem: GistFileViewBindingModel
      ): Boolean = oldItem.id == newItem.id

      override fun areContentsTheSame(
        oldItem: GistFileViewBindingModel,
        newItem: GistFileViewBindingModel
      ): Boolean = oldItem == newItem
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): GistFileViewerViewHolder =
    GistFileViewerViewHolder.create(
      LayoutInflater.from(context),
      parent
    )


  override fun onBindViewHolder(holder: GistFileViewerViewHolder, position: Int) {
    holder.bindTo(getItem(position))
  }

}