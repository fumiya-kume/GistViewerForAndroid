package com.example.kuxu.gistviewerforandroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuxu.gistviewerforandroid.R
import kotlinx.android.synthetic.main.activity_gist_post.*

class GistPostActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_gist_post)
    setSupportActionBar(toolbar)
  }
}
