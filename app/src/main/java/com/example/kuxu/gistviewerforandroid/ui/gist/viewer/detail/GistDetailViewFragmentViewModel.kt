package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import androidx.lifecycle.ViewModel
import com.example.kuxu.gistviewerforandroid.domain.usecase.AddGistFavoriteUsecase
import com.example.kuxu.gistviewerforandroid.domain.usecase.RemoveGistFavoriteUsecase
import com.example.kuxu.gistviewerforandroid.service.ChromeCustomTabsService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import java.util.concurrent.TimeUnit

internal class GistDetailViewFragmentViewModel(
  private val targetGistId: String,
  private val gistInfoamtionLiveDataFactory: GistDetailLiveDataFactory,
  private val gistDetailFileListLiveDataFactory: GistDetailFileListLiveDataFactory,
  private val chromeCustomTabsService: ChromeCustomTabsService,
  private val addGistFavoriteUsecase: AddGistFavoriteUsecase,
  private val removeGistFavoriteUsecase: RemoveGistFavoriteUsecase
) : ViewModel() {
  val gistDetailLiveData: GistDetailLiveData = gistInfoamtionLiveDataFactory.create(targetGistId)
  val gistDetailFileListLiveData: GistDetailFileListLiveData = gistDetailFileListLiveDataFactory.create(targetGistId)

  val disposable = CompositeDisposable()

  fun OpenGistFileOnBrowser(rawUrl: String) {
    chromeCustomTabsService.OpenChrome(rawUrl)
  }

  fun addFavorite(targetGistId: String, beforeFavorite: Boolean) {
    GlobalScope.launch {
      updateFavoriteStatus(targetGistId, true)
      addGistFavoriteUsecase.execute(targetGistId)
        .toObservable<Unit>()
        .throttleLast(10L, TimeUnit.MILLISECONDS)
        .subscribeBy(
          onError = {
            updateFavoriteStatus(targetGistId, beforeFavorite)
          }
        )
        .addTo(disposable)
    }
  }

  fun removeFavorite(targetGistId: String, beforeFavorite: Boolean) {
    GlobalScope.launch {
      updateFavoriteStatus(targetGistId, false)
      removeGistFavoriteUsecase.execute(targetGistId)
        .toObservable<Unit>()
        .throttleLast(10L, TimeUnit.MILLISECONDS)
        .subscribeBy(
          onError = {
            updateFavoriteStatus(targetGistId, beforeFavorite)
          }
        )
        .addTo(disposable)
    }
  }

  fun updateFavoriteStatus(targetGistId: String, favoriteStatus: Boolean) {
    gistDetailLiveData.value = gistDetailLiveData.value?.copy(favorite = favoriteStatus)
  }

  override fun onCleared() {
    super.onCleared()

    disposable.dispose()
  }
}