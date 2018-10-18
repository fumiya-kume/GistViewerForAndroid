package com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail

import androidx.lifecycle.LiveData
import com.example.kuxu.gistviewerforandroid.domain.repository.GistDetailRepository
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel.GistDetailBindingModel
import com.example.kuxu.gistviewerforandroid.ui.gist.viewer.detail.bindingModel.GistDetailConverter
import io.reactivex.rxkotlin.subscribeBy

internal class GistDetailLiveData(
  private val targetGistId: String,
  private val gistDetailRepository: GistDetailRepository
) : LiveData<GistDetailBindingModel>() {
  override fun onActive() {
    super.onActive()
    gistDetailRepository
      .loadGistDetail(targetGistId)
      .subscribeBy(
        onSuccess = {
          value = GistDetailConverter.convert(it)
        },
        onError = {
          // 良さげなエラー処理を考える, とりあえずはエラーメッセージを表示しとくだけ
          value = GistDetailBindingModel("", "対象のGist が見つかりませんでした","","","","",false)
        }
      )
  }
}


