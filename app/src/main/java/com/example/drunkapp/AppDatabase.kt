package com.example.drunkapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.domain.CocktailDao

@Database(entities = arrayOf(CocktailEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun cocktailDao(): CocktailDao

}