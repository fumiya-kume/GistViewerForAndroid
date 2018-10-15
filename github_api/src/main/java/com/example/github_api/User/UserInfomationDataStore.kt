package com.example.github_api.User

import com.example.github_api.User.Entity.UserInfomation
import io.reactivex.Single

public interface UserInfomationDataStore{
    fun userInfomation(): Single<UserInfomation>
}