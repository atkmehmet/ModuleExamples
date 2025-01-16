package com.example.data_repository.repository

import com.example.data_repository.data_source.local.LocalPostDataSource
import com.example.data_repository.data_source.local.LocalUserDataSource
import com.example.data_repository.data_source.remote.RemotePostDataSource
import com.example.mylibrary.entity.Post
import com.example.mylibrary.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PostRepositoryImp @Inject constructor(
    private val remotePostDataSource: RemotePostDataSource,
    private val localPostDataSource: LocalPostDataSource
):PostRepository {
    override fun getPosts(): Flow<List<Post>> =
        remotePostDataSource.getPosts()
            .onEach {
                localPostDataSource.addPosts(it)
            }

    override fun getPost(id:Long) :Flow<Post> =
        remotePostDataSource.getPost(id)
            .onEach {
                localPostDataSource.addPosts(listOf(it))
            }
}