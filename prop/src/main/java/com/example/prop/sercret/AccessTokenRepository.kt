package com.example.prop.sercret

interface AccessTokenRepository {
    fun saveAccessToken(accessToken: String)
    fun loadAccessToken(): String
}