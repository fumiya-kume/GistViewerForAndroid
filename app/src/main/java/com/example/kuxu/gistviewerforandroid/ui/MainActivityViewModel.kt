package com.example.kuxu.gistviewerforandroid.ui

import androidx.lifecycle.ViewModel
import org.koin.standalone.KoinComponent

internal class MainActivityViewModel(): ViewModel() {
    fun getGreeting() = "Hello Work"
}
