package com.example.kuxu.gistviewerforandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kuxu.gistviewerforandroid.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainActivity : AppCompatActivity() {

    val viewModel:MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        message.text = viewModel.getGreeting()
    }
}