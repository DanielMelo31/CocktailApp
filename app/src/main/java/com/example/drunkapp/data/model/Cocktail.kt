package com.example.drunkapp.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cocktail(
    @SerializedName("idDrink")
    val cocktailId: String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strInstructions")
    val description: String = "",
    @SerializedName("strAlcoholic")
    val alcoholicDrink: String = ""
): Parcelable

data class CocktailList(
    @SerializedName("drinks")
    val cocktailList: List<Cocktail>
)

@Entity
data class CocktailEntity(
    @PrimaryKey
    val cocktailId: String,
    @ColumnInfo(name = "cocktail_image")
    val image: String = "",
    @ColumnInfo(name = "cocktail_name")
    val name: String = "",
    @ColumnInfo(name = "cocktailInstructions")
    val description: String = "",
    @ColumnInfo(name = "alcoholic_status")
    val alcoholicDrink: String = ""
)


