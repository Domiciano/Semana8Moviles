package com.example.pokebase.retrofit

import com.example.pokebase.repository.PokemonFirebaseRepository
import com.example.pokebase.repository.PokemonRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val pokeAPI = Retrofit
        .Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val realtimeDBAPI = Retrofit
        .Builder()
        .baseUrl("https://facelogprueba.firebaseio.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val pokeAPIService = pokeAPI.create(PokemonRepository::class.java)
    val realtimeDBAPIService = realtimeDBAPI.create(PokemonFirebaseRepository::class.java)


}