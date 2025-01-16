package com.example.data_repository.injection

import com.example.data_repository.repository.InteractionRepositoryImp
import com.example.data_repository.repository.UserRepositoryImp
import com.example.mylibrary.repository.InteractionRepository
import com.example.mylibrary.repository.PostRepository
import com.example.mylibrary.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(potRepositoryImp: InteractionRepositoryImp):PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImp: UserRepositoryImp):UserRepository

    @Binds
    abstract fun bindInteractionRepository(interactionRepositoryImp: InteractionRepositoryImp):InteractionRepository
}