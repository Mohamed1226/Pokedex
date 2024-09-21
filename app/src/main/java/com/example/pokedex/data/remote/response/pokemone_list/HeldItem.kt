package com.example.pokedex.data.remote.response.pokemone_list

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)