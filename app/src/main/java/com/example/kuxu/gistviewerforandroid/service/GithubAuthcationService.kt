package com.example.kuxu.gistviewerforandroid.service

import kotlinx.coroutines.experimental.Deferred

internal interface GithubAuthcationService{
    fun AuthWithAccessToken(accessToken: String): Deferred<String>
}