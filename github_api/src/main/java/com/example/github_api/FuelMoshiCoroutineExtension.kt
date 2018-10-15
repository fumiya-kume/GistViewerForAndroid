package com.example.github_api

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.response
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.kittinunf.result.Result
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async

// Response が欲しいとき
inline fun <reified T : Any> Request.awaitResponseObject(): Deferred<Triple<Request, Response, Result<T, FuelError>>> {
  val request = this
  return GlobalScope.async {
    return@async request.response(moshiDeserializerOf<T>())
  }
}

// Result だけが欲しいとき
inline fun <reified T : Any> Request.awaitResultObject(): Deferred<Result<T, FuelError>> {
  val request = this
  return GlobalScope.async {
    return@async request.response(moshiDeserializerOf<T>()).third
  }
}