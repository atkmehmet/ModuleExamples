package com.example.mylibrary.UseCase

import com.example.mylibrary.entity.Interaction
import com.example.mylibrary.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UpdateInteractionUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val interactionRepository: InteractionRepository
):UseCase<UpdateInteractionUseCase.Request,UpdateInteractionUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> {
     return interactionRepository.saveInteraction(request.intrecaction).map {
         Response
     }
    }
    data class Request(val intrecaction:Interaction):UseCase.Request
    object Response:UseCase.Response
}