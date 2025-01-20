package com.example.data_local.injection

import android.content.Context
import androidx.room.Room
import com.example.data_local.db.AppDatabase
import com.example.data_local.db.post.PostDao
import com.example.data_local.db.user.UserDao
import com.example.data_local.source.LocalInteractionDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences
import javax.sql.DataSource


val Context.datastore:DataSource<Preferences> by
preferencesDataStore(name = "my_preferences")
@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my-database"
        ).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase):
            UserDao = appDatabase.userDao()

    @Provides
    fun providePostDao(appDatabase: AppDatabase):PostDao
    = appDatabase.postDao()

    @Provides
    fun provideLocalInteractionDataSourceImpl
                (@ApplicationContext context: Context) =
        LocalInteractionDataSourceImpl(context.datastore)
}