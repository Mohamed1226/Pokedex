package com.example.pokedex.data.remote.response.pokemon_list

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)