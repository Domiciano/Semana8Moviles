package com.example.pokebase.model

data class Pokemon(
    var id:String,
    var name:String,
    var sprites: Sprites,
    var stats : ArrayList<Stat>
)
data class Sprites(
    var front_default:String
)
data class Stat(
    var base_stat:Int,
    var stat:StatName
)
data class StatName(
    var name:String
)