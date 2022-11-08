package com.colddelight.base_example.repository

import com.colddelight.base_example.data.Post
import com.colddelight.base_example.data.PostDataSource

class PostRepositoryImpl(
    private val api :PostDataSource
):PostRepository{
    override suspend fun getPost(): List<Post> {
        return api.getPost()
    }
}