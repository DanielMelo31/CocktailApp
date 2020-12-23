package com.example.drunkapp.domain

import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.vo.Resource

interface Repo {
    suspend fun getCocktailList(cocktailName: String) : Resource<List<Cocktail>>
    suspend fun getFavoritesCocktails(): Resource<List<CocktailEntity>>
    suspend fun insertCocktail(cocktail: CocktailEntity)
}