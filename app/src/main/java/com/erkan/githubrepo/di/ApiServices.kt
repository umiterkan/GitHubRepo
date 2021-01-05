package com.erkan.githubrepo.di

import com.erkan.githubrepo.data.model.Repo
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by umiterkan on 1/2/2021
 */
interface ApiServices {

    @GET("users/{username}/repos")
    suspend fun getRepoList(@Path("username") username: String): Response<List<Repo>>
}