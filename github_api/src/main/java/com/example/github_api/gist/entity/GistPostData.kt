package com.example.github_api.gist.entity

public data class GistPostData(
  val description: String,
  val public: Boolean,
  val files: Map<String,content>
)

public data class content(
  val content: String
)
