package com.example.drunkapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drunkapp.AppDatabase
import com.example.drunkapp.R
import com.example.drunkapp.data.DataSourceImpl
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.domain.RepoImpl
import com.example.drunkapp.ui.viewmodel.MainViewModel
import com.example.drunkapp.vo.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class FavoritesFragment : Fragment(),  CocktailAdapter.OnCocktailClickListener {
    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
    }

    private fun setupObservers() {
        viewModel.getFavoriteCocktail().observe(viewLifecycleOwner, Observer {result ->
            when (result) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    val list = result.data.map {
                        Cocktail(it.image, it.name,it.description)
                    }
                    rvCocktailsFav.adapter = CocktailAdapter(requireContext(), list, this)
                    Log.d("Favorites", "${result.data}")
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "An error has occurred ${result.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rvCocktailsFav.layoutManager = LinearLayoutManager(requireContext())
        rvCocktailsFav.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onCocktailClick(cocktail: Cocktail) {
        val bundle = Bundle()
        bundle.putParcelable("Cocktail", cocktail)
        findNavController().navigate(R.id.cocktailDetailFragment, bundle)
    }

}

