package com.example.kuxu.gistviewerforandroid.ui.gist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.kuxu.gistviewerforandroid.ui.gist.bindingModel.GistOverViewItemBindingModel

internal class GistOverViewAdapter(
  private val context: Context
) : ListAdapter<GistOverViewItemBindingModel, GistOverViewViewHolder>(
  ITEM_CALLBACK
) {

  companion object {
    private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<GistOverViewItemBindingModel>() {
      override fun areItemsTheSame(
        oldItem: GistOverViewItemBindingModel,
        newItem: GistOverViewItemBindingModel
      ): Boolean {
        return oldItem.id == newItem.id
      }

      override fun areContentsTheSame(
        oldItem: GistOverViewItemBindingModel,
        newItem: GistOverViewItemBindingModel
      ): Boolean {
        return oldItem == newItem
      }
    }
  }

  override fun onBindViewHolder(holder: GistOverViewViewHolder, position: Int) {
    holder.bindTo(getItem(position))
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): GistOverViewViewHolder = GistOverViewViewHolder.create(
    LayoutInflater.from(context),
    parent,
    false
  )
}