package com.example.gist.ui.viewer.detail

import androidx.lifecycle.LiveData
import com.example.gist.domain.repository.GistDetailRepository
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailFileBindingModel
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailFileConverter
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

internal class GistDetailFileListLiveData(
  private val targetGistId: String,
  private val gistDetailRepository: GistDetailRepository
  ) : LiveData<List<GistDetailFileBindingModel>>() {
  override fun onActive() {
    super.onActive()

    GlobalScope.launch(Dispatchers.Main) {
      gistDetailRepository.loadGistDetail(targetGistId)
        .subscribeBy(
          onSuccess = {
            value = GistDetailFileConverter.convert(it)
          },
          onError = {
            //TODO 取得できなかった場合にどうするかはあとで考える, とりあえず動作に問題が無く、仕様をみたいしている空のリストを返しておく
            value = emptyList()
          }
        )
    }
  }
}