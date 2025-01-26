package com.example.representation_posts.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostList(
    postListModel: PostListModel
){
    LazyColumn( modifier = Modifier.padding(16.dp))
    {
        item (postListModel.headerText){
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = postListModel.headerText)
            }
        }
        items(postListModel.items){ item ->
            Column(modifier = Modifier
                .padding(16.dp)) {
                Text(text = item.authorName)
                Text(text = item.title
                )
            }

        }
    }
}