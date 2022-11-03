package com.colddelight.base_example.data

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPost(): List<Post>
}