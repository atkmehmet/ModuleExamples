package com.example.mylibrary

import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    fun getUser(id:String): Flow<User>
}