package com.example.github_api.gist

import com.example.github_api.gist.entity.GistPostData
import io.reactivex.Completable

public interface PostGistService {
  fun PostGist(postData: GistPostData): Completable
}