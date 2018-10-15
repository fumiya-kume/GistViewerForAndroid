package com.example.github_api

import com.github.kittinunf.fuel.core.*
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

// List などのリストをデシリアライズするようになやつを使うときに
inline fun <reified T : Any> Request.awaitResultObject(deserializer: ResponseDeserializable<T>): Deferred<Result<T, FuelError>> {
  val request = this
  return GlobalScope.async {
    return@async request.responseObject(deserializer).third
  }
}