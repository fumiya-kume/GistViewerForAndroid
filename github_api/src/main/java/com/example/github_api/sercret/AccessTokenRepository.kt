package com.example.github_api.sercret

import io.reactivex.Single

interface AccessTokenRepository {
    fun saveAccessToken(accessToken: String): Single<String>
    fun loadAccessToken(): String
}