package com.example.gist.ui.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github_api.gist.PostGistService
import com.example.github_api.gist.entity.Content
import com.example.github_api.gist.entity.GistPostData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

internal class GistEditorFragmentViewModel(
  private val gistService: PostGistService,
  private val gistFileLiveDataFactory: GistFileLiveDataFactory
) : ViewModel() {

  val disposable = CompositeDisposable()
  val gistFileLiveData = gistFileLiveDataFactory.create()

  val PostDone = MutableLiveData<Boolean>().apply {
    value = false
  }

  fun post(
    description: String
  ) {
    val postData = GistPostData(
      description = description,
      public = true,
      files = gistFileLiveData.value?.map { it.fileName to Content(it.content) }?.toMap()
        ?: emptyMap())

    gistService.PostGist(postData)
      .subscribeBy(
        onComplete = {
          PostDone.value = true
        },
        onError = {
          PostDone.value = false
        }
      ).addTo(disposable)
  }

  fun AddNewFile(fileName: String, content: String) {
    gistFileLiveData.AddNewFile(
      fileName,
      content
    )
  }

  override fun onCleared() {
    super.onCleared()

    disposable.dispose()
  }
}