package com.example.representation_posts.list

sealed class UiState<out T : Any> {
    object Loading : UiState<Nothing>()
    data class Error(val errorMessage: String) : UiState<Nothing>()  // No need for <T>
    data class Success<T : Any>(val data: T) : UiState<T>()
}
