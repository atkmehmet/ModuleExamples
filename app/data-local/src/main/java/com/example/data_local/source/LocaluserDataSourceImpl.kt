package com.example.data_local.source

import com.example.data_local.db.user.UserDao
import com.example.data_local.db.user.UserEntity
import com.example.data_repository.data_source.local.LocalUserDataSource
import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocaluserDataSourceImpl @Inject constructor(
    val userDao: UserDao
):LocalUserDataSource {
    override fun getUsers(): Flow<List<User>> =
        userDao.getUsers().map { users ->
            users.map {
                User(it.id,it.name,it.username,it.email)
            }
        }

    override suspend fun addUsers(users: List<User>) =
        userDao.insertUsers(users.map {
            UserEntity(it.id,it.firstName,it.lastName,it.email)
        })
}