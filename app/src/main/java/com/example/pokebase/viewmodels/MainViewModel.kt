package com.example.pokebase.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokebase.model.Pokemon
import com.example.pokebase.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val pokemons = arrayListOf<Pokemon>()
    val pokemonsLiveData = MutableLiveData(pokemons)

    fun getPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            var pokemonMap = RetrofitClient.realtimeDBAPIService
                .getPokemons()
                .execute()
                .body()
            pokemonMap?.let {
                pokemons.clear()
                for ( value in it.values){
                    pokemons.add(value)
                }
                withContext(Dispatchers.Main){
                    pokemonsLiveData.value = pokemons
                }
            }
        }


    }


}