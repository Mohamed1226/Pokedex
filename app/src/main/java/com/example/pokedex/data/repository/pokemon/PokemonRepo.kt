package com.example.pokedex.data.repository.pokemon

import com.example.pokedex.data.remote.PokemonApi
import com.example.pokedex.data.remote.response.pokemon.Pokemon
import com.example.pokedex.data.remote.response.pokemon_list.PokemonList
import com.example.pokedex.util.ResultState

class PokemonRepo(private val pokemonApi: PokemonApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): ResultState<PokemonList> {
        val response = try {
            pokemonApi.getPokemonList(limit, offset)

        } catch (e: Exception) {
            return ResultState.Error(message = e.message.toString())

        }
        return ResultState.Success(date = response)
    }

    suspend fun getPokemonInfo(name: String): ResultState<Pokemon> {
        val response = try {
            pokemonApi.getPokemon(name)

        } catch (e: Exception) {
            return ResultState.Error(message = e.message.toString())

        }
        return ResultState.Success(date = response)
    }
}