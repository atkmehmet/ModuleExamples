package com.example.mylibrary

import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    fun getUser(id:String): Flow<User>
}