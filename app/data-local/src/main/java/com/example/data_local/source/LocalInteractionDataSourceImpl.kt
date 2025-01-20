package com.example.data_local.source

import com.example.data_repository.data_source.local.LocalInteractionDataSource
import com.example.mylibrary.entity.Interaction
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences
import javax.inject.Inject
import javax.sql.DataSource

internal val KEY_TOTAL_TAPS = intPreferencesKey("key_total_taps")
class LocalInteractionDataSourceImpl @Inject constructor(
    private val dataStore:DataSource<Preferences>
) : LocalInteractionDataSource{

    override fun getInteraction(): Flow<Interaction> {
        return dataStore.data.map {
            Interaction(it[KEY_TOTAL_TAPS] ?:0)
        }
    }

    override suspend fun saveInteraction(interaction: Interaction) {
        dataStore.edit{
            it[KEY_TOTAL_TAPS] =
                interaction.totalClicks
        }
    }
}