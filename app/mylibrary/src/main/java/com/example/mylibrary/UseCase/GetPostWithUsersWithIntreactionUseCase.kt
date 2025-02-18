package com.example.mylibrary.UseCase

import com.example.mylibrary.entity.Interaction
import com.example.mylibrary.entity.PostWithUser
import com.example.mylibrary.repository.InteractionRepository
import com.example.mylibrary.repository.PostRepository
import com.example.mylibrary.repository.UserRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
class GetPostsWithUsersWithInteractionUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val interactionRepository:InteractionRepository
) :UseCase<GetPostsWithUsersWithInteractionUseCase.Request,GetPostsWithUsersWithInteractionUseCase.Response>(configuration) {
    override fun process(request: Request): Flow<Response> =
        combine(
            postRepository.getPosts(),
            userRepository.getUsers(),
            interactionRepository.getInteraction()
        ) { posts, users, interaction ->
            val postUsers = posts.map { post ->
                val user = users.first() {
                    it.id == post.userId
                }
                PostWithUser(post, user)
            }
            Response(postUsers, interaction)
        }

    object Request : UseCase.Request

    data class Response(
        val posts: List<PostWithUser>,
        val interaction: Interaction
    ):UseCase.Response
}