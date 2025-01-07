package com.example.mylibrary

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id:String):Flow<User>

    fun refreshUser(id:String):Flow<User>
}