package com.example.kuxu.gistviewerforandroid.infra

import android.content.Context
import androidx.core.content.edit

internal class AccessTokenRepositoryImpl(
        private val context: Context
) {
    val preferenceKey = "GistViewer"
    val accessKey = "AccessToken"
    val preference = context.getSharedPreferences(preferenceKey, Context.MODE_PRIVATE)

    fun saveAccessToken(accessToken: String) {
        preference.edit { putString(accessKey, accessToken) }
    }

    fun loadAccessToken() = preference.getString(accessKey, "")!!
}