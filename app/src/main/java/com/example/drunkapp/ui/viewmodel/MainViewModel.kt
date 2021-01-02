 package com.example.drunkapp.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.domain.Repo
import com.example.drunkapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val repo: Repo) : ViewModel() {
    private val cocktailData = MutableLiveData<String>()

    fun setCocktailData(cocktailName: String) {
        cocktailData.value = cocktailName
    }

    init {
        setCocktailData("Margarita")
    }

    val fetchCocktailList = cocktailData.distinctUntilChanged().switchMap { cocktailName ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                emit(repo.getCocktailList(cocktailName))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun saveCocktail(cocktail: CocktailEntity) {
        viewModelScope.launch {
            repo.insertCocktail(cocktail)
        }
    }

    fun getFavoriteCocktail() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getFavoritesCocktails())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}
