package com.example.kuxu.gistviewerforandroid.ui.gist.post

import androidx.lifecycle.LiveData
import com.example.kuxu.gistviewerforandroid.ui.gist.post.bindingModel.GistEditorFileBindingModel

internal class GistFilesLiveData internal constructor() : LiveData<List<GistEditorFileBindingModel>>() {

  override fun onActive() {
    super.onActive()

    value = value ?: emptyList()

    value?.isEmpty()?.let {
      if (it) {
        AddNewFile()
      }
    }

  }

  fun AddNewFile() {
    value?.let {
      value = it.toMutableList().apply {
        add(
          GistEditorFileBindingModel("", "")
        )
      }
    }
  }

  fun updateFile(file: GistEditorFileBindingModel) {
    value?.also {
      value = it.map { if (it.fileName == file.fileName) file else it }
    }
  }
}
