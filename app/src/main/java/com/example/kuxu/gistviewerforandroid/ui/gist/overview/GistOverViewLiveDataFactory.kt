package com.example.kuxu.gistviewerforandroid.ui.gist.overview

import com.example.github_api.gist.AuthzedUserGistDataStore
import com.example.github_api.gist.CheckIfStaredGist

internal class GistOverViewLiveDataFactory(
  private val authzedUserGistDataStore: AuthzedUserGistDataStore,
  private val checkIfStaredGist: CheckIfStaredGist
) {
  fun create(): GistOverViewLiveData = GistOverViewLiveData(
    authzedUserGistDataStore,
    checkIfStaredGist
  )
}
