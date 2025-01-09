package com.example.mylibrary.repository

import com.example.mylibrary.entity.Interaction
import kotlinx.coroutines.flow.Flow

interface InteractionRepository {
    fun getInteraction(): Flow<Interaction>

    fun saveInteraction(interaction: Interaction):
            Flow<Interaction>
}