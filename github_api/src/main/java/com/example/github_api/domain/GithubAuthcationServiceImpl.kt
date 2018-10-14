package com.example.github_api.domain

import awaitStringResult
import com.example.prop.GithubProperties
import com.github.kittinunf.fuel.Fuel
import io.reactivex.Single
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

internal class GithubAuthcationServiceImpl(
        private val githubProperties: GithubProperties
) : GithubAuthcationService {
    override fun AuthWithCode(code: String): Single<String> =
            Single.fromCallable {
                runBlocking {
                    sendAuthcationMessage(code).await()
                }
            }

    private fun sendAuthcationMessage(code: String): Deferred<String> =
            GlobalScope.async {
                val url = "https://github.com/login/oauth/access_token?code=$code&client_id=${githubProperties.clientId}&client_secret=${githubProperties.ClientSercret}"
                Fuel.post(url).awaitStringResult()
                        .fold({
                            val result = Regex("([=&])").split(it)
                            return@async result.elementAt(1)
                        }, {
                            throw it.exception
                        })
            }
}