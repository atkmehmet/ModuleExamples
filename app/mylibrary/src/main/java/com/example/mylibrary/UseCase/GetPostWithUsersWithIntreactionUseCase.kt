package com.example.mylibrary.UseCase

import com.example.mylibrary.UserRepository
import com.example.mylibrary.entity.Interaction
import com.example.mylibrary.entity.PostWithUser
import com.example.mylibrary.repository.InteractionRepository
import com.example.mylibrary.repository.PostRepository
import kotlinx.coroutines.flow.combine
import java.util.concurrent.Flow
import javax.inject.Inject


class GetPostsWithUsersWithInteractionUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val interactionRepository:InteractionRepository
):GetPostsWithUsersWithInteractionUseCase

{
    override fun process (request: Request):Flow<Response> =
        combine(
            postRepository.getPosts(),
            userRepository.getUser(),
            interactionRepository.getInteraction()
        ){posts, user, interaction ->
            val postUsers = posts.map {
                post ->
                 val user = user.first {
                     it.id == post.UserId
                 }
                PostWithUser(post, user)
            }
            Response(postUsers,interaction)
        }
    object Request : UseCase.Request

    data class Response(
        val posts: List<PostWithUser>,
        val interaction: Interaction
    ):UseCase.Response
}