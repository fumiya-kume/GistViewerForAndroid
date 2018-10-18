package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview

import androidx.lifecycle.LiveData
import com.example.github_api.gist.AuthzedUserGistDataStore
import com.example.github_api.gist.CheckIfStaredGist
import com.example.github_api.gist.entity.Gist
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.overview.bindingModel.GistOverViewItemBindingModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

internal class GistOverViewLiveData(
  private val authzedUserGistDataStore: AuthzedUserGistDataStore,
  private val checkIfStaredGist: CheckIfStaredGist
) : LiveData<List<GistOverViewItemBindingModel>>() {
  override fun onActive() {
    super.onActive()

    authzedUserGistDataStore.loadGistList()
      .subscribeBy(
        onSuccess = {
          value = GistOverViewItemConverter.convertToBindingModel(it)
          GlobalScope.launch {
            checkForFavorite(it)
          }
        },
        onError = {
          value = emptyList()
        }
      )
  }

  private fun checkForFavorite(gitstList: List<Gist>) {
    gitstList.forEach {
      checkIfStaredGist.StaredGistList(it.id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy {
          val (targetId, targetStared) = it
          value = value?.map { if (it.id == targetId) it.copy(favorite = targetStared) else it }
        }
    }
  }
}