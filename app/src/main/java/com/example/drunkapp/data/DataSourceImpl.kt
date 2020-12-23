package com.example.drunkapp.data

import com.example.drunkapp.AppDatabase
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.domain.CocktailDao
import com.example.drunkapp.domain.DataSourceRepo
import com.example.drunkapp.vo.Resource
import com.example.drunkapp.vo.RetrofitClient
import javax.inject.Inject

class DataSourceImpl @Inject constructor(private  val cocktailDao: CocktailDao): DataSourceRepo {
    override suspend fun getCocktailByName(cocktailName: String ) : Resource<List<Cocktail>>{
        return Resource.Success(RetrofitClient.webservice.getCocktailName(cocktailName).cocktailList)
    }
    override suspend fun insertCocktailInRoom(cocktail: CocktailEntity) {
        cocktailDao.insertFavoriteCocktail(cocktail)
    }
    override suspend fun getFavoritesCocktails(): Resource<List<CocktailEntity>> {
        return Resource.Success(cocktailDao.getAllFavoritesCocktails())
    }

}
