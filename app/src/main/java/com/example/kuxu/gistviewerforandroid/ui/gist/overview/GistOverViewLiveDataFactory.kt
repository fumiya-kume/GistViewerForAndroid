package com.example.kuxu.gistviewerforandroid.ui.gist.overview

import com.example.github_api.gist.AuthzedUserGistDataStore

internal class GistOverViewLiveDataFactory(
  private val authzedUserGistDataStore: AuthzedUserGistDataStore
) {
  fun create(): GistOverViewLiveData = GistOverViewLiveData(
    authzedUserGistDataStore
  )
}
