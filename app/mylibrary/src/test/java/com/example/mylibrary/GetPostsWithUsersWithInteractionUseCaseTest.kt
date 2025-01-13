package com.example.mylibrary

import androidx.compose.runtime.ExperimentalComposeApi
import com.example.mylibrary.UseCase.GetPostsWithUsersWithInteractionUseCase
import com.example.mylibrary.entity.Interaction
import com.example.mylibrary.entity.Post
import com.example.mylibrary.entity.PostWithUser
import com.example.mylibrary.entity.User
import com.example.mylibrary.repository.InteractionRepository
import com.example.mylibrary.repository.PostRepository
import com.example.mylibrary.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetPostsWithUsersWithInteractionUseCaseTest {
    private val postRepository = mock<PostRepository>()
    private val userRepository = mock<UserRepository>()
    private val interactionRepository = mock<InteractionRepository>()

    private  val useCase = GetPostsWithUsersWithInteractionUseCase(
        mock(),
        postRepository,
        userRepository,
        interactionRepository
    )

    @ExperimentalComposeApi
    @Test
    fun testProcess() = runBlockingTest{
        val user1 = User(1L,"name1","username1","email")
        val user2 = User(2L,"name2","username2","email2")

        val post1 = Post(1L,user1.id,"title","body")
        val post2 = Post(2L,user1.id,"title","body2")
        val post3 = Post(3L,user2.id,"title3","body3")
        val post4 = Post(4L,user2.id,"title4","body4")

        val interaction = Interaction(10)

        whenever(postRepository.getPosts()).thenReturn
        (flowOf(listOf(post1,post2,post3,post4)))

        whenever(userRepository.getUsers()).thenReturn
        (flowOf(listOf(user1,user2)))

        whenever(interactionRepository.getInteraction()).thenReturn
        (flowOf(interaction))

        val response = useCase.process(GetPostsWithUsersWithInteractionUseCase.Request).first()

        assertEquals(
            GetPostsWithUsersWithInteractionUseCase.Response(
                listOf(
                    PostWithUser(post1,user1),
                    PostWithUser(post2,user1),
                    PostWithUser(post3,user2),
                    PostWithUser(post4,user1),
                ),interaction
            ),response
        )
    }
}