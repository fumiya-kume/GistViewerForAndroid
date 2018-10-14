package com.example.github_api.infra.domain

import com.example.github_api.domain.Entity.UserInfomation
import com.example.github_api.domain.UserInfomationRepository
import io.reactivex.Single

public class UserInfomationRepositoryImpl : UserInfomationRepository {
    override fun userInfomation(): Single<UserInfomation> =
            Single.just(
                    UserInfomation("hello")
            )

}