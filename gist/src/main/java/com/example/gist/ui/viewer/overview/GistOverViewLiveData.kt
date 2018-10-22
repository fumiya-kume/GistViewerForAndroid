package com.example.gist.ui.viewer.overview

import androidx.lifecycle.LiveData
import com.example.gist.ui.viewer.overview.bindingModel.GistOverViewItemBindingModel
import com.example.github_api.gist.AuthzedUserGistDataStore
import com.example.github_api.gist.CheckIfStaredGist
import com.example.github_api.gist.entity.Gist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

internal class GistOverViewLiveData(
  private val authzedUserGistDataStore: AuthzedUserGistDataStore,
  private val checkIfStaredGist: CheckIfStaredGist
) : LiveData<List<GistOverViewItemBindingModel>>() {

  val disposable = CompositeDisposable()

  override fun onActive() {
    super.onActive()

    refreshGistList()
  }

  fun refreshGistList() {
    GlobalScope.launch {
      authzedUserGistDataStore.loadGistList()
        .subscribeBy(
          onSuccess = {
            GlobalScope.launch(Dispatchers.Main)
            {
              value = GistOverViewItemConverter.convertToBindingModel(it)
            }
            checkForFavorite(it)

          },
          onError = {
            value = emptyList()
          }
        ).addTo(disposable)
    }
  }

  override fun onInactive() {
    super.onInactive()

    disposable.dispose()
  }

  private fun checkForFavorite(gitstList: List<Gist>) {
    gitstList.forEach {
      checkIfStaredGist.StaredGistList(it.id)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy {
          val (targetId, targetStared) = it
          value = value?.map { if (it.id == targetId) it.copy(favorite = targetStared) else it }
        }.addTo(disposable)
    }
  }
}