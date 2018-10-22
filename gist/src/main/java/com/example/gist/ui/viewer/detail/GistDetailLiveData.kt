package com.example.gist.ui.viewer.detail

import androidx.lifecycle.MutableLiveData
import com.example.github_api.gist.CheckIfStaredGist
import com.example.gist.domain.repository.GistDetailRepository
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailBindingModel
import com.example.gist.ui.viewer.detail.bindingModel.GistDetailConverter
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

internal class GistDetailLiveData(
  private val targetGistId: String,
  private val gistDetailRepository: GistDetailRepository,
  private val checkIfStaredGist: CheckIfStaredGist
) : MutableLiveData<GistDetailBindingModel>() {
  override fun onActive() {
    super.onActive()
    gistDetailRepository
      .loadGistDetail(targetGistId)
      .subscribeBy(
        onSuccess = {
          value = GistDetailConverter.convert(it)

          GlobalScope.launch(Dispatchers.Main) {
            checkIfStaredGist.StaredGistList(targetGistId)
              .subscribeBy(
                onSuccess = {
                  val (_, checkResult) = it
                  value = value?.copy(favorite = checkResult)
                },
                onError = {

                }
              )
          }
        },
        onError = {
          // 良さげなエラー処理を考える, とりあえずはエラーメッセージを表示しとくだけ
          value = GistDetailBindingModel("", "対象のGist が見つかりませんでした", "", "", "", "", false)
        }
      )
  }
}


