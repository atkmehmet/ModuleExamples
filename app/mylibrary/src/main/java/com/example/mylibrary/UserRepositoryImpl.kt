package com.example.mylibrary

import com.example.mylibrary.entity.User
import com.example.mylibrary.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource,
                         private val userLocalDataSource: UserLocalDataSource
 ):UserRepository {
    override fun getUser(id: String): Flow<User> = userRemoteDataSource.getUser(id)

    override fun refreshUser(id: String): Flow<User> = userRemoteDataSource.getUser(id).onEach {
        userLocalDataSource.insertUser(it)
    }
}