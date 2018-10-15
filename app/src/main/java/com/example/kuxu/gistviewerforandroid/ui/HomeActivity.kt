package com.example.kuxu.gistviewerforandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuxu.gistviewerforandroid.R
import kotlinx.android.synthetic.main.activity_home.*

internal class HomeActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    setSupportActionBar(toolbar)

    fab.setOnClickListener { view ->
      val intent = Intent(this, GistPostActivity::class.java)
      startActivity(intent)
    }
  }
}