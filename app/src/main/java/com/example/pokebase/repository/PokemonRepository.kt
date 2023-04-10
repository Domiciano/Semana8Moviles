package com.example.pokebase.repository


import com.example.pokebase.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PokemonRepository {

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id:String) : Call<Pokemon>




}