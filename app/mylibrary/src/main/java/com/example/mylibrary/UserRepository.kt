package com.example.mylibrary

import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id:String):Flow<User>

    fun refreshUser(id:String):Flow<User>
}