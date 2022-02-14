package com.pacoglez.superheroapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pacoglez.superheroapp.databinding.LayoutHeroItemBinding
import com.pacoglez.superheroapp.model.HeroModel

class HeroRecyclerViewAdapter(private val itemClickListener: ClickListener) : RecyclerView.Adapter<ItemViewHolder>() {

    var heroes = emptyList<HeroModel>()

    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = LayoutHeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val hero = heroes[position]

        holder.bind(hero)
        holder.itemView.setOnClickListener{itemClickListener.itemSelect(heroes[position])}
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

}

class ItemViewHolder(private val binding: LayoutHeroItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(hero: HeroModel) {
        binding.textViewName.text = hero.name

        Glide.with(binding.root.context)
            .load(hero.images.sm)
            .into(binding.imageViewPicture)
    }
}