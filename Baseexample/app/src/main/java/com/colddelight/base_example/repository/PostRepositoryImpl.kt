package com.colddelight.base_example.repository

import android.util.Log
import com.colddelight.base_example.data.NetworkObject
import com.colddelight.base_example.data.Post

class PostRepositoryImpl():PostRepository{
    override suspend fun getPost(): List<Post> {
        return NetworkObject.getRetrofitService.getPost()
    }
}