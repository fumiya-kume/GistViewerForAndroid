package com.example.github_api.infra

import awaitStringResponse
import com.example.github_api.domain.GithubService
import com.example.prop.sercret.AccessTokenRepository
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.Completable
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

internal class GithubServiceImpl(
        private val accessTokenRepository: AccessTokenRepository
) : GithubService, GithubServiceSetting {

    private val accessToken = accessTokenRepository.loadAccessToken()

    init {
        FuelManager.instance.basePath = "https://api.github.com"
        if (!accessToken.isEmpty()) {
            FuelManager.instance.baseHeaders = mapOf("Authorization" to "token$accessToken")
        }
    }


    private data class Gist(val url: String)

    override fun loadGistCount(): Deferred<Int> =
            GlobalScope.async {
                fun <T> seliazeList(content: String): List<T>? {
                    val moshi = Moshi.Builder().build()
                    val type = Types.newParameterizedType(List::class.java, Gist::class.java)
                    val listAdapter: JsonAdapter<List<T>> = moshi.adapter(type)
                    return listAdapter.fromJson(content)
                }

                val result = "/gists".httpGet().awaitStringResponse()
                result.third.fold(
                        {
                            return@async seliazeList<Gist>(it)?.count() ?: 0
                        },
                        {
                            return@async -1
                        }
                )
            }

    override fun updateAccessToken(accessToken: String): Completable =
            Completable.fromAction {
                accessTokenRepository.saveAccessToken(accessToken)
            }
}