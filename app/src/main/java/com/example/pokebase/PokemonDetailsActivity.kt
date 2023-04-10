package com.example.pokebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.pokebase.databinding.ActivityMainBinding
import com.example.pokebase.databinding.ActivityPokemonDetailsBinding
import com.example.pokebase.viewmodels.PokemonDetailsViewModel

class PokemonDetailsActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityPokemonDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel:PokemonDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val goal = intent.extras?.getString("goal")
        goal?.let {
            viewModel.getDetail(it)
            viewModel.pokemon.observe(this){pokemon ->
                binding.nameTV.text = pokemon.name
                binding.defenseTV.text = pokemon.stats[2].base_stat.toString()
                binding.attackTV.text = pokemon.stats[1].base_stat.toString()
                binding.hpTV.text = pokemon.stats[0].base_stat.toString()
                binding.speedTV.text = pokemon.stats[5].base_stat.toString()
                Glide.with(this)
                    .load(pokemon.sprites.front_default)
                    .centerCrop()
                    .into(binding.pokeIMG)

            }
            binding.button.setOnClickListener {

            }

        }


    }
}