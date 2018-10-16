package com.example.kuxu.gistviewerforandroid.ui.gist.post

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kuxu.gistviewerforandroid.GistEditorFragment
import com.example.kuxu.gistviewerforandroid.R

class GistPostActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_gist_post)
    supportFragmentManager.beginTransaction().apply {
      replace(
        R.id.container,
        GistEditorFragment()
      )
    }.commitNow()
  }
}