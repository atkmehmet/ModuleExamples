package com.example.mylibrary

import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser():Flow<User>

    fun refreshUser(id:Long):Flow<User>
}