package com.example.mylibrary

import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun insertUser(user: User)

    fun getUser(id:String):Flow<User>
}