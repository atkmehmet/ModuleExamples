package com.example.data_repository.data_source.remote

import com.example.mylibrary.entity.Post
import kotlinx.coroutines.flow.Flow

interface RemotePostDataSource {

    fun getPosts(): Flow<List<Post>>

    fun getPost(id: Long):Flow<Post>
}