package com.example.github_api.infra

import kotlinx.coroutines.experimental.Deferred

public interface GithubService {
    fun loadGistCount():Deferred<Int>
}