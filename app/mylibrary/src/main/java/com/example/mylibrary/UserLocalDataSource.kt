package com.example.mylibrary

interface UserLocalDataSource {
    suspend fun insertUser(user: User)
}