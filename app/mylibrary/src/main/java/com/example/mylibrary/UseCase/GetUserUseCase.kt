package com.example.mylibrary.UseCase

import com.example.mylibrary.entity.User
import com.example.mylibrary.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val userRepository: UserRepository
) :UseCase<GetUserUseCase.Request,GetUserUseCase.Response>(configuration){
    override fun process(request: GetUserUseCase.Request): Flow<GetUserUseCase.Response> =
        userRepository.getUser(request.userId).map {
            Response(it)
        }

    data class Request(val userId:Long):UseCase.Request
    data class Response(val user: User):UseCase.Response
}