package com.example.gist.ui.post

import androidx.lifecycle.LiveData
import com.example.gist.ui.post.bindingModel.GistFileViewBindingModel

internal class GistFilesLiveData internal constructor() : LiveData<List<GistFileViewBindingModel>>() {

  override fun onActive() {
    super.onActive()
    value = value ?: emptyList()
  }

  fun AddNewFile(fileName: String = "", content: String = "") {
    value?.let {
      value = it.toMutableList().apply {
        val nextId = this.map { it.id }.max() ?: 1
        add(
          GistFileViewBindingModel(nextId, fileName, content)
        )
      }
    }
  }
}
