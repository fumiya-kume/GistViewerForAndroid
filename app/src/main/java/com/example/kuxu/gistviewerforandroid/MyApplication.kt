package com.example.kuxu.gistviewerforandroid

import android.app.Application
import com.example.kuxu.gistviewerforandroid.ui.MainActivityViewModel
import com.example.kuxu.gistviewerforandroid.ui.uiModule
import org.koin.android.ext.android.startKoin
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import org.koin.dsl.module.module

internal class MyApplication : Application() {

    private val module: Module = module {

    }

    override fun onCreate() {
        super.onCreate()

        startKoin(
                this,
                listOf(uiModule)
        )
    }
}