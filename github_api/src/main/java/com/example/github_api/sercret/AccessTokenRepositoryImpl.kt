package com.example.github_api.sercret

import android.content.Context
import androidx.core.content.edit
import com.example.github_api.startGithubClient
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

internal class AccessTokenRepositoryImpl(
  context: Context
) : AccessTokenRepository {
  private val preferenceKey = "GistViewer"
  private val accessKey = "AccessToken"
  private val preference = context.getSharedPreferences(
    preferenceKey,
    Context.MODE_PRIVATE
  )

  override fun saveAccessToken(
    accessToken: String
  ) =
    Single.fromCallable {
      preference.edit {
        putString(
          accessKey,
          accessToken
        )
      }
      startGithubClient()
      return@fromCallable accessToken
    }.observeOn(Schedulers.computation())

  override fun loadAccessToken() = preference.getString(accessKey, "")!!
}