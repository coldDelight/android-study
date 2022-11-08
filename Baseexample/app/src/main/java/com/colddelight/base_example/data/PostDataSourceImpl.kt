package com.colddelight.base_example.data

import retrofit2.Retrofit
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): PostDataSource {
    override suspend fun getPost(): List<Post>{
        return retrofit.create(PostDataSource::class.java).getPost()
    }
}