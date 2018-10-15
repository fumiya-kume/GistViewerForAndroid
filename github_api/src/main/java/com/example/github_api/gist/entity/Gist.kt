package com.example.github_api.gist.entity


import com.squareup.moshi.Json

data class Owner(@Json(name = "gists_url")
                 val gistsUrl: String = "",
                 @Json(name = "repos_url")
                 val reposUrl: String = "",
                 @Json(name = "following_url")
                 val followingUrl: String = "",
                 @Json(name = "starred_url")
                 val starredUrl: String = "",
                 @Json(name = "login")
                 val login: String = "",
                 @Json(name = "followers_url")
                 val followersUrl: String = "",
                 @Json(name = "type")
                 val type: String = "",
                 @Json(name = "url")
                 val url: String = "",
                 @Json(name = "subscriptions_url")
                 val subscriptionsUrl: String = "",
                 @Json(name = "received_events_url")
                 val receivedEventsUrl: String = "",
                 @Json(name = "avatar_url")
                 val avatarUrl: String = "",
                 @Json(name = "events_url")
                 val eventsUrl: String = "",
                 @Json(name = "html_url")
                 val htmlUrl: String = "",
                 @Json(name = "site_admin")
                 val siteAdmin: Boolean = false,
                 @Json(name = "id")
                 val id: Int = 0,
                 @Json(name = "gravatar_id")
                 val gravatarId: String = "",
                 @Json(name = "node_id")
                 val nodeId: String = "",
                 @Json(name = "organizations_url")
                 val organizationsUrl: String = "")


data class Gist(@Json(name = "owner")
                val owner: Owner,
                @Json(name = "commits_url")
                val commitsUrl: String = "",
                @Json(name = "comments")
                val comments: Int = 0,
                @Json(name = "forks_url")
                val forksUrl: String = "",
                @Json(name = "git_push_url")
                val gitPushUrl: String = "",
                @Json(name = "created_at")
                val createdAt: String = "",
                @Json(name = "description")
                val description: String = "",
                @Json(name = "truncated")
                val truncated: Boolean = false,
                @Json(name = "url")
                val url: String = "",
                @Json(name = "public")
                val public: Boolean = false,
                @Json(name = "updated_at")
                val updatedAt: String = "",
                @Json(name = "html_url")
                val htmlUrl: String = "",
                @Json(name = "git_pull_url")
                val gitPullUrl: String = "",
                @Json(name = "comments_url")
                val commentsUrl: String = "",
                @Json(name = "files")
                val files: Map<String, File>,
                @Json(name = "id")
                val id: String = "",
                @Json(name = "node_id")
                val nodeId: String = "")


data class File(
  @Json(name = "filename") val fileName: String
)


