package com.example.github_api.domain

import io.reactivex.Single

public interface GithubAuthcationService{
    fun AuthWithCode(code: String): Single<String>
}