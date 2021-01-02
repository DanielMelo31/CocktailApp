package com.example.drunkapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.drunkapp.AppDatabase
import com.example.drunkapp.R
import com.example.drunkapp.data.DataSourceImpl
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.data.model.CocktailEntity
import com.example.drunkapp.domain.RepoImpl
import com.example.drunkapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cokctail_detail.*

@AndroidEntryPoint
class CocktailDetailFragment : Fragment() {
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var cocktail: Cocktail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            cocktail = it.getParcelable("Cocktail")!!
            //Log.d("Detail", "$cocktail")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cokctail_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext()).load(cocktail.image).centerCrop().into(imgCocktailDetailPic)
        tvCocktailDetailName.text = cocktail.name
        tvCocktailDetailDescription.text = cocktail.description
        if (cocktail.alcoholicDrink == "Alcoholic") {
            tvAlcoholicDrink.text = "This cocktail has alcohol"
        } else {
            tvAlcoholicDrink.text = "This cocktail does not have alcohol"
        }
        btnAddToFavorites.setOnClickListener {
            viewModel.saveCocktail(
                CocktailEntity(
                    cocktail.cocktailId,
                    cocktail.name,
                    cocktail.image,
                    cocktail.description,
                    cocktail.alcoholicDrink
                )
            )
            Toast.makeText(
                requireContext(), "Cocktail saved to favorites", Toast.LENGTH_SHORT
            ).show()
        }

    }

}