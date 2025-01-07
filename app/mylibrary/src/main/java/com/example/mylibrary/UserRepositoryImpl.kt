package com.example.mylibrary

import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource):UserRepository {
    override fun getUser(id: String): Flow<User> = userRemoteDataSource.getUser(id)
}