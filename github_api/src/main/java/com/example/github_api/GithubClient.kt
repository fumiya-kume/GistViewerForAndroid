package com.example.github_api

import com.example.github_api.sercret.AccessTokenRepository
import com.github.kittinunf.fuel.core.FuelManager
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

fun startGithubClient() {
  val accessTokenRepository: AccessTokenRepository = object : KoinComponent {
    val accessTokenRepository: AccessTokenRepository by inject()
  }.accessTokenRepository
  val accessToken = accessTokenRepository.loadAccessToken()
  FuelManager.instance.basePath = "https://api.github.com"
  if (!accessToken.isEmpty()) {
    FuelManager.instance.baseHeaders = mapOf("Authorization" to "token $accessToken")
  }
}