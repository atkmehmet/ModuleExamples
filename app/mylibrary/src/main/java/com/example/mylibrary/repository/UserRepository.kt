package com.example.mylibrary.repository

import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers():Flow<List<User>>

    fun getUser(id: Long):Flow<User>
}