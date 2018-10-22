package com.example.gist.ui.viewer.detail

import androidx.lifecycle.ViewModel
import com.example.gist.domain.service.ChromeCustomTabsService
import com.example.gist.domain.usecase.AddGistFavoriteUsecase
import com.example.gist.domain.usecase.RemoveGistFavoriteUsecase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.Dispatchers
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

  fun addFavorite(targetGistId: String) {
    GlobalScope.launch(Dispatchers.Main) {
      updateFavoriteStatus(targetGistId, true)
      addGistFavoriteUsecase.execute(targetGistId)
        .toObservable<Unit>()
        .throttleLast(10L, TimeUnit.MILLISECONDS)
        .subscribeBy(
          onError = {
            updateFavoriteStatus(targetGistId, false)
          }
        )
        .addTo(disposable)
    }
  }

  fun removeFavorite(targetGistId: String) {
    GlobalScope.launch(Dispatchers.Main) {
      updateFavoriteStatus(targetGistId, false)
      removeGistFavoriteUsecase.execute(targetGistId)
        .toObservable<Unit>()
        .throttleLast(10L, TimeUnit.MILLISECONDS)
        .subscribeBy(
          onError = {
            updateFavoriteStatus(targetGistId, true)
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