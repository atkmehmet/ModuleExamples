package com.example.data_repository.repository

import com.example.data_repository.data_source.local.LocalInteractionDataSource
import com.example.mylibrary.entity.Interaction
import com.example.mylibrary.repository.InteractionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InteractionRepositoryImp @Inject constructor(
    private val interactionDataSource: LocalInteractionDataSource
):InteractionRepository {
    override fun getInteraction(): Flow<Interaction> =
        interactionDataSource.getInteraction()

    override fun saveInteraction(interaction: Interaction): Flow<Interaction>  = flow {
        interactionDataSource.saveInteraction(interaction)
        this.emit(Unit)
    }.flatMapLatest {
        getInteraction()
    }
}