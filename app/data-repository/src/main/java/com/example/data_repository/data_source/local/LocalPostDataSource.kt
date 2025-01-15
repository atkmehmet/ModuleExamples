package com.example.data_repository.data_source.local

import com.example.mylibrary.entity.Post
import kotlinx.coroutines.flow.Flow

interface LocalPostDataSource {
    fun getPosts(): Flow<List<Post>>

    suspend fun addPosts(posts: List<Post>)
}