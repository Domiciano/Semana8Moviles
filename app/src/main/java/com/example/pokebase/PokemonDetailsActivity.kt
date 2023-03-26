package com.example.pokebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokebase.databinding.ActivityMainBinding
import com.example.pokebase.databinding.ActivityPokemonDetailsBinding

class PokemonDetailsActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityPokemonDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}