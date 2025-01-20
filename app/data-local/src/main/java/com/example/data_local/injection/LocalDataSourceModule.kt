package com.example.data_local.injection

import com.example.data_local.source.LocalInteractionDataSourceImpl
import com.example.data_local.source.LocalPostDataSourceImpl
import com.example.data_local.source.LocaluserDataSourceImpl
import com.example.data_repository.data_source.local.LocalInteractionDataSource
import com.example.data_repository.data_source.local.LocalPostDataSource
import com.example.data_repository.data_source.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindPostDataSource
                (lostDataSourceImpl:LocalPostDataSourceImpl):
            LocalPostDataSource

    @Binds
    abstract fun bindUserDataSource
                (userDataSourceImpl: LocaluserDataSourceImpl):
            LocalUserDataSource

    @Binds
    abstract fun bindInteractionDataStore
                (interactionDataStore:LocalInteractionDataSourceImpl):
            LocalInteractionDataSource
}