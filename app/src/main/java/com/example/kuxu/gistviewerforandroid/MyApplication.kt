package com.example.kuxu.gistviewerforandroid

import android.app.Application
import com.example.github_api.githubServiceModule
import com.example.kuxu.gistviewerforandroid.infra.infraModule
import com.example.kuxu.gistviewerforandroid.service.serviceModule
import com.example.kuxu.gistviewerforandroid.ui.uiModule
import com.example.prop.propModule
import org.koin.android.ext.android.startKoin

internal class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val MainActivitymodule = listOf(
                uiModule,
                serviceModule,
                infraModule
        )

        startKoin(
                this,
                listOf(
                        propModule,
                        githubServiceModule
                ) + MainActivitymodule
        )
    }
}