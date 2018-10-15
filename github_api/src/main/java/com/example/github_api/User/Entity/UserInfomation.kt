package com.example.github_api.User.Entity

import com.squareup.moshi.Json

public data class UserInfomation(
  @Json(name = "name") val userName: String
)