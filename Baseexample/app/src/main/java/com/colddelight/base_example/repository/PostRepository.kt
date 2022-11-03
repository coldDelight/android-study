package com.colddelight.base_example.repository

import com.colddelight.base_example.data.Post

interface PostRepository {
    suspend fun getPost(): List<Post>
}