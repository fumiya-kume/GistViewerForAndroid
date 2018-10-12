package com.example.github_api

import kotlinx.coroutines.experimental.Deferred

public interface GithubService {
    fun updateAccessToken(accessToken: String)
    fun loadGistCount():Deferred<Int>
}