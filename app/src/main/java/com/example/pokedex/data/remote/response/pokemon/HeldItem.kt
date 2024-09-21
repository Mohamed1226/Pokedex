package com.example.pokedex.data.remote.response.pokemon

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)