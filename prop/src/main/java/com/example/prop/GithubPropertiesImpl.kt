package com.example.prop

import android.os.Build

public class GithubPropertiesImpl(
        override val clientId: String = BuildConfig.client_id,
        override val ClientSercret: String = BuildConfig.client_sercret
):GithubProperties