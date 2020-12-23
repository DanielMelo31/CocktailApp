package com.example.drunkapp.di

import android.content.Context
import androidx.room.Room
import com.example.drunkapp.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRoomInstance(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, AppDatabase::class.java, "cocktail_table").build()

    @Singleton
    @Provides
    fun provideTragosDao(RoomDB: AppDatabase) = RoomDB.cocktailDao()
}