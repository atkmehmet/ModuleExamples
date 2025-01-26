package com.example.representation_posts.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

@Composable
fun PostListScreeb(
    viewModel: PostListViewModel
){
    viewModel.loadPosts()
    viewModel.postListFlow.collectAsState().value.let {state ->
        when(state){
            is UiState.Loading ->{
                Loading()
            }
            is UiState.Error ->{
                com.example.representation_posts.list.Error(state.errorMessage)
            }
            is UiState.Success -> {
                com.example.representation_posts.list.PostList(state.data)
            }
        }
    }
}