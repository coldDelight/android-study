package com.colddelight.base_example.data

import retrofit2.http.GET

interface PostDataSource {
    @GET("/posts")
    suspend fun getPost():List<Post>
}