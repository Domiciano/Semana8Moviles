package com.example.pokebase.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokebase.model.Pokemon
import com.example.pokebase.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID

class PokemonDetailsViewModel : ViewModel(){

    //Variables que se mostrarán en la vista
    val pokemon: MutableLiveData<Pokemon> = MutableLiveData()


    fun getDetail(id:String){
        viewModelScope.launch(Dispatchers.IO){
            //Retrofit
            val result = RetrofitClient.pokeAPIService.getPokemonById(id)
                .execute()
                .body()
            result?.id = UUID.randomUUID().toString()

            withContext(Dispatchers.Main){
                result?.let {
                    pokemon.value = it
                }
            }
        }
    }

    fun catchPokemon(){
        val p = pokemon.value
        p?.let {
            viewModelScope.launch(Dispatchers.IO) {
                RetrofitClient.realtimeDBAPIService.postPokemon(it.id, it)
                    .execute()
            }
        }
    }






}