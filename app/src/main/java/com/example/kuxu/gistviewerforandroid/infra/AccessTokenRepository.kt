package com.example.kuxu.gistviewerforandroid.infra

interface AccessTokenRepository {
    fun saveAccessToken(accessToken: String)
    fun loadAccessToken(): String
}