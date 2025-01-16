package com.example.data_repository.repository

import com.example.data_repository.data_source.local.LocalUserDataSource
import com.example.data_repository.data_source.remote.RemoteUserDataSource
import com.example.mylibrary.entity.User
import com.example.mylibrary.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val localUserDataSource: LocalUserDataSource
):UserRepository {
    override fun getUsers(): Flow<List<User>> =
        remoteUserDataSource.getUsers().onEach {
            localUserDataSource.addUsers(it)
        }


    override fun getUser(id: Long): Flow<User> =
        remoteUserDataSource.getUser(id).onEach {
            localUserDataSource.addUsers(listOf(it))
        }
}