package com.example.github_api.User

import com.example.github_api.User.Entity.UserInfomation
import com.example.github_api.awaitResultObject
import com.github.kittinunf.fuel.httpGet
import io.reactivex.Single
import kotlinx.coroutines.experimental.runBlocking

internal class UserInfomationDataStoreImpl : UserInfomationDataStore {
  override fun userInfomation(): Single<UserInfomation> =
    Single.just(
      runBlocking {
        "/user".httpGet().awaitResultObject<UserInfomation>().await()
          .fold(success = {
            return@runBlocking it
          }, failure = {
            throw it.exception
          })
      }
    )
}
