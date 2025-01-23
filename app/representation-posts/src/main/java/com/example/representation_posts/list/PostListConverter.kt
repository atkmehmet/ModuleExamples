package com.example.representation_posts.list

import android.content.Context
import com.example.mylibrary.UseCase.GetPostsWithUsersWithInteractionUseCase
import com.example.mylibrary.entity.Result
import com.example.representation_posts.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PostListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun convert(postListResult: Result<GetPostsWithUsersWithInteractionUseCase.Response>):UiState<PostListModel> {
        return when (postListResult){
            is Result.Error-> {
                UiState.Error(postListResult.exception.localizedMessage.orEmpty())
            }
            is Result.Succes->{
                UiState.Success(PostListModel(
                    headerText = context.getString(

                    )
                ))
            }
        }
    }
}