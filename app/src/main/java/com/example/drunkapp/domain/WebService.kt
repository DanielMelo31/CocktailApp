package com.example.drunkapp.domain

import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php")
    suspend fun getCocktailName(@Query("s") cocktailName: String) : CocktailList
}