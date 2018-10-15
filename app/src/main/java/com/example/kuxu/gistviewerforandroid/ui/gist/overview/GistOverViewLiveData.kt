package com.example.kuxu.gistviewerforandroid.ui.gist.overview

import androidx.lifecycle.LiveData
import com.example.github_api.gist.AuthzedUserGistDataStore
import com.example.kuxu.gistviewerforandroid.ui.gist.overview.bindingModel.GistOverViewItemBindingModel
import io.reactivex.rxkotlin.subscribeBy

internal class GistOverViewLiveData(
  private val authzedUserGistDataStore: AuthzedUserGistDataStore
) : LiveData<List<GistOverViewItemBindingModel>>() {
  override fun onActive() {
    super.onActive()

    authzedUserGistDataStore.loadGistList()
      .subscribeBy(
        onSuccess = {
          value = GistOverViewItemConverter.convertToBindingModel(it)
        },
        onError = {
          value = emptyList()
        }
      )
  }
}