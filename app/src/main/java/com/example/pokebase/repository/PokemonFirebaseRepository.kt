package com.example.pokebase.repository

import com.example.pokebase.model.Pokemon
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PokemonFirebaseRepository {

    @POST("")
    fun postPokemon(@Body pokemon:Pokemon) : Call<Any>

}