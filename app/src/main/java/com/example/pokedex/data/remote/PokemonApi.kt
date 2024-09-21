package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.response.pokemone_list.Pokemon
import com.example.pokedex.data.remote.response.pokemone_list.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET(value = "pokemon")
    suspend fun getPokemonList(
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Int
    ): PokemonList

    @GET(value = "pokemon/{name}")
    suspend fun getPokemon(
        @Path(value = "name") name: String,
    ): Pokemon
}