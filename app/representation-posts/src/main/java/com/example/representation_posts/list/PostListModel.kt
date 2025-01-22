package com.example.representation_posts.list

data class PostListModel(
    val headerText: String = "",
    val items: List<PostListItemModel> = listOf()
)
