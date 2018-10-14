package com.example.github_api.domain

import kotlinx.coroutines.experimental.Deferred

public interface GithubService {
    fun loadGistCount():Deferred<Int>
}