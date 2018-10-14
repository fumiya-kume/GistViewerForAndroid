package com.example.kuxu.gistviewerforandroid.service

import kotlinx.coroutines.experimental.Deferred

internal interface GithubAuthcationService{
    fun AuthWithCode(code: String): Deferred<String>
}