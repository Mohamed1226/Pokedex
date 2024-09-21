package com.example.pokedex.data.remote.response.pokemone_list

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)