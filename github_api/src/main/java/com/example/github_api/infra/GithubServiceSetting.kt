package com.example.github_api.infra

import io.reactivex.Completable

public interface GithubServiceSetting {
    fun updateAccessToken(accessToken: String): Completable
}