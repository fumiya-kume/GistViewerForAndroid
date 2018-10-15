package com.example.github_api.Auth

import io.reactivex.Single

public interface GithubAuthcationService{
    fun authWithCode(code: String): Single<String>
}