package com.example.pokebase.repository

import com.example.pokebase.model.Pokemon
import retrofit2.Call
import retrofit2.http.*

interface PokemonFirebaseRepository {

    @PUT("pokemons/{id}.json")
    fun postPokemon(@Path("id") id:String, @Body pokemon:Pokemon) : Call<Any>

    @GET("pokemons.json")
    fun getPokemons() : Call< HashMap<String, Pokemon> >

}