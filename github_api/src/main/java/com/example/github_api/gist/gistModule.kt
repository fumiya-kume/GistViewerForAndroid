package com.example.github_api.gist

import org.koin.dsl.module.module

internal val gistModule = module {
  factory { AuthzedUserGistDataStoreImpl() as AuthzedUserGistDataStore }
  factory { PostGistServiceImpl() as PostGistService }
  factory { CheckIfStaredGistImpl() as CheckIfStaredGist }
  factory { GetSpecificGistImpl() as GetSpecificGist }
}