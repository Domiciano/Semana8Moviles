package com.example.pokebase.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.pokebase.PokemonDetailsActivity
import com.example.pokebase.model.Pokemon
import com.example.pokebase.viewholders.PokemonVH
import com.example.pokebase.R

class PokemonAdapter : Adapter<PokemonVH>() {

    val arr = ArrayList<Pokemon>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        return PokemonVH(
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.pokemonName.text = arr[position].name
        holder.actionBtn.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(holder.itemView.context, PokemonDetailsActivity::class.java)
            )
        }
    }

    fun addAllPokemon(array:ArrayList<Pokemon>){
        arr.clear()
        arr.addAll(array)
        notifyDataSetChanged()
    }


}