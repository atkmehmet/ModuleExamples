package com.example.data_repository.data_source.local

import com.example.mylibrary.entity.Interaction
import kotlinx.coroutines.flow.Flow


interface LocalInteractionDataSource {
    fun getInteraction(): Flow<Interaction>

    suspend fun saveInteraction(interaction: Interaction)
}