package com.example.data_remote.source

import com.example.data_remote.networking.post.PostApiModel
import com.example.data_remote.networking.post.PostService
import com.example.data_repository.data_source.remote.RemotePostDataSource
import com.example.mylibrary.entity.Post
import com.example.mylibrary.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemotePostDataSourceImpl @Inject constructor(
    private val postService: PostService
):RemotePostDataSource {

    override fun getPosts(): Flow<List<Post>> = flow {
        emit(postService.getPosts())
    }.map {  posts ->
        posts.map { postApiModel ->
            convert(postApiModel)
        }

    }.catch {
        throw UseCaseException.PostException(it)
    }

    override fun getPost(id: Long): Flow<Post> = flow {
        emit(postService.getPost(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.PostException(it)
    }

    private fun convert(postApiModel: PostApiModel) =
        Post(postApiModel.id,postApiModel.userId,postApiModel.title,postApiModel.body)
}