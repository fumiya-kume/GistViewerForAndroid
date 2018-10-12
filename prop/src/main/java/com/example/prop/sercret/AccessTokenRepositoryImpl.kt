package com.example.prop.sercret

import android.content.Context
import androidx.core.content.edit

internal class AccessTokenRepositoryImpl(
        private val context: Context
) : AccessTokenRepository {
    private val preferenceKey = "GistViewer"
    private val accessKey = "AccessToken"
    private val preference = context.getSharedPreferences(
            preferenceKey,
            Context.MODE_PRIVATE
    )

    override fun saveAccessToken(
            accessToken: String
    ) {
        preference.edit {
            putString(
                    accessKey,
                    accessToken
            )
        }
    }

    override fun loadAccessToken() = preference.getString(accessKey, "")!!
}