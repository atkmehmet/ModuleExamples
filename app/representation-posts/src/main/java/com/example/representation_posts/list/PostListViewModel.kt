package com.example.representation_posts.list

import com.example.mylibrary.UseCase.GetPostsWithUsersWithInteractionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val useCase: GetPostsWithUsersWithInteractionUseCase,
    private val converter: PostListConverter
):ViewModel() {

    private val _postListFlow =
        MutableStateFlow<UiState<PostListModel>>(UiState.Loading)

    val postListFlow:
            StateFlow<UiState<PostListModel>> =
        _postListFlow

    fun loadPosts(){
          viewModelScope.launch {
              useCase.execute
              (GetPostsWithUsersWithInteractionUseCase.Request)
                  .map {
                      converter.convert(it)
                  }
                  .collect{
                      _postListFlow.value = it
                  }
          }
    }
}