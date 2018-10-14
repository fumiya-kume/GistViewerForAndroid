package com.example.kuxu.gistviewerforandroid.service

import io.reactivex.Single

internal interface GithubAuthcationService{
    fun AuthWithCode(code: String): Single<String>
}