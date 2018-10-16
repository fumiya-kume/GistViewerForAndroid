package com.example.github_api.gist.entity

public data class GistPostData(
  val description: String,
  val public: Boolean,
  val files: Map<String,Content>
)

public data class Content(
  val content: String
)
