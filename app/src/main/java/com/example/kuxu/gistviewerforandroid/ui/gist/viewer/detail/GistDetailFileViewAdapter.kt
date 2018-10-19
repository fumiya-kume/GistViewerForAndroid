package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel.GistDetailFileBindingModel

internal class GistDetailFileViewAdapter(
  private val context: Context
) : ListAdapter<GistDetailFileBindingModel, GistFileViewHolder>(ITEM_CALLBACK) {
  companion object {
    private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<GistDetailFileBindingModel>() {
      override fun areItemsTheSame(
        oldItem: GistDetailFileBindingModel,
        newItem: GistDetailFileBindingModel
      ): Boolean {
        return oldItem.id == newItem.id

      }

      override fun areContentsTheSame(
        oldItem: GistDetailFileBindingModel,
        newItem: GistDetailFileBindingModel
      ): Boolean {
        return oldItem == newItem
      }
    }
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): GistFileViewHolder =
    GistFileViewHolder.create(
      LayoutInflater.from(context),
      parent
    )

  var gistDetailClickListener: OnGistDetailClickListener? = null

  override fun onBindViewHolder(holder: GistFileViewHolder, position: Int) =
    holder.bindTo(
      getItem(position),
      gistDetailClickListener
    )
}