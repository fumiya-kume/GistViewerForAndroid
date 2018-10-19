package com.example.kuxu.gistviewerforandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.kuxu.gistviewerforandroid.R

internal class HomeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
  }

  override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}