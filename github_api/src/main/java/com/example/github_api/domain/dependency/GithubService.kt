package com.example.github_api.domain.dependency

import kotlinx.coroutines.experimental.Deferred

internal interface GithubService {
    fun loadGistCount():Deferred<Int>
}