package com.example.kuxu.gistviewerforandroid.ui.gist.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github_api.gist.PostGistService
import com.example.github_api.gist.entity.Content
import com.example.github_api.gist.entity.GistPostData
import io.reactivex.rxkotlin.subscribeBy

internal class GistEditorFragmentViewModel(
  private val gistService: PostGistService
) : ViewModel() {

  val PostDone = MutableLiveData<Boolean>().apply {
    value = false
  }

  fun post(
    description: String,
    content: String
  ) {
    val postData = GistPostData(
      description = description,
      public = true,
      files = mapOf
      (pair = description to Content(content)))
    gistService.PostGist(postData)
      .subscribeBy(
        onComplete = {
          PostDone.value = true
        },
        onError = {
          PostDone.value = false
        }
      )
  }
}