package com.example.kuxu.gistviewerforandroid.service

import awaitStringResult
import com.example.prop.GithubProperties
import com.github.kittinunf.fuel.Fuel
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

internal class GithubAuthcationServiceImpl(
        private val githubProperties: GithubProperties
) : GithubAuthcationService {
    override fun AuthWithCode(code: String) =
            GlobalScope.async {
                val url = "https://github.com/login/oauth/access_token?code=$code&client_id=${githubProperties.clientId}&client_secret=${githubProperties.ClientSercret}"
                Fuel.post(url).awaitStringResult()
                        .fold({
                            val result = Regex("([=&])").split(it)
                            return@async result.elementAt(1)
                        }, {
                            return@async ""
                        })

            }

}