package com.example.drunkapp.domain

import androidx.room.*
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity

@Dao
interface CocktailDao {
    @Query("SELECT * FROM CocktailEntity")
    suspend fun getAllFavoritesCocktails(): List<CocktailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteCocktail(cocktail:CocktailEntity)

}