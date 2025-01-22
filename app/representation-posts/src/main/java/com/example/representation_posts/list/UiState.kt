package com.example.representation_posts.list

sealed class UiState<T : Any> {
    object Loading : UiState<Nothing>()

    data class Error<T : Any> (val errorMessage:String) : UiState<T>()

    data class Success<T : Any>(val data: T) : UiState<T>()
}