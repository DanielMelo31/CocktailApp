package com.example.drunkapp.domain

import com.example.drunkapp.data.DataSourceImpl
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.vo.Resource
import javax.inject.Inject

class RepoImpl @Inject constructor(private val dataSourceImpl: DataSourceImpl): Repo {
    override suspend fun getCocktailList(cocktailName: String): Resource<List<Cocktail>> {
        return dataSourceImpl.getCocktailByName(cocktailName)
    }

    override suspend fun getFavoritesCocktails(): Resource<List<CocktailEntity>> {
        return dataSourceImpl.getFavoritesCocktails()
    }

    override suspend fun insertCocktail(cocktail: CocktailEntity) {
        dataSourceImpl.insertCocktailInRoom(cocktail)
    }

}