package com.example.drunkapp.domain

import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.vo.Resource
import com.example.drunkapp.vo.RetrofitClient

interface DataSourceRepo {
    suspend fun getCocktailByName(cocktailName: String ) : Resource<List<Cocktail>>
    suspend fun insertCocktailInRoom(cocktail: CocktailEntity)
    suspend fun getFavoritesCocktails(): Resource<List<CocktailEntity>>
}