package com.example.kuxu.gistviewerforandroid.ui.gist.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kuxu.gistviewerforandroid.ui.gist.post.bindingModel.GistEditorFileBindingModel

internal class GistFileEditorAdapter(
  private val context: Context
) : ListAdapter<GistEditorFileBindingModel, GistFileEditorViewHolder>(ITEM_CALLBACK) {

  companion object {
    private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<GistEditorFileBindingModel>() {
      override fun areItemsTheSame(
        oldItem: GistEditorFileBindingModel,
        newItem: GistEditorFileBindingModel
      ): Boolean {
        return oldItem.fileName == newItem.fileName
      }

      override fun areContentsTheSame(
        oldItem: GistEditorFileBindingModel,
        newItem: GistEditorFileBindingModel
      ): Boolean {
        return oldItem == newItem
      }
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): GistFileEditorViewHolder =
    GistFileEditorViewHolder.create(
      LayoutInflater.from(context),
      parent
    )

  override fun onBindViewHolder(
    holder: GistFileEditorViewHolder,
    position: Int
  ) {
    holder.bindTo(getItem(position))
  }
}