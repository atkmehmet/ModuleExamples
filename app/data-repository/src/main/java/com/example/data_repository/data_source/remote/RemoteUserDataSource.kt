package com.example.data_repository.data_source.remote

import com.example.mylibrary.entity.User
import kotlinx.coroutines.flow.Flow


interface RemoteUserDataSource {
    fun getUsers(): Flow<List<User>>
}