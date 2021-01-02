package com.example.drunkapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drunkapp.R
import com.example.drunkapp.base.BaseViewHolder
import com.example.drunkapp.data.model.Cocktail
import com.example.drunkapp.databinding.ItemCocktailBinding
import kotlinx.android.synthetic.main.item_cocktail.view.*

class CocktailAdapter(
    private val context: Context,
    private val cocktailList: List<Cocktail>,
    private val itemClickListener: OnCocktailClickListener
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnCocktailClickListener{
        fun onCocktailClick(cocktail : Cocktail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val layoutBinding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailViewHolder(layoutBinding)
    }

    override fun getItemCount(): Int {
        return cocktailList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CocktailViewHolder ->
                holder.bind(cocktailList[position], position)
        }
    }

    inner class CocktailViewHolder(itemView: ItemCocktailBinding) : BaseViewHolder<Cocktail>(itemView.root) {
        override fun bind(item: Cocktail, position: Int) {
            itemView.apply {
                Glide.with(context).load(item.image).centerCrop().into(imgCocktailPic)
                tvCocktailName.text = item.name
                tvCocktailName.text = item.name
                setOnClickListener { itemClickListener.onCocktailClick(item) }
            }
        }
    }
}