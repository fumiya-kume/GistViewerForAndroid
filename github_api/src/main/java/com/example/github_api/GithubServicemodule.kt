package com.example.github_api

import com.example.github_api.Auth.authModule
import com.example.github_api.User.usermodule
import com.example.github_api.sercret.sercretModule

public val githubServiceModule = listOf(
  sercretModule,
  authModule,
  usermodule
)