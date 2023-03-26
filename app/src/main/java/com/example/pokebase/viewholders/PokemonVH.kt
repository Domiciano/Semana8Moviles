package com.example.pokebase.viewholders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokebase.databinding.PokemonViewBinding

class PokemonVH(root: View) : ViewHolder(root) {

    private val binding:PokemonViewBinding = PokemonViewBinding.bind(root)

    val pokemonImg:ImageView = binding.pokemonImg
    val pokemonName:TextView = binding.pokemonName
    val actionBtn:Button = binding.actionBtn

}