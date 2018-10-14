package com.example.github_api.domain

import com.example.github_api.domain.Entity.UserInfomation
import io.reactivex.Single

public interface UserInfomationRepository{
    fun userInfomation(): Single<UserInfomation>
}