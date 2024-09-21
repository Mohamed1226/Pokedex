package com.example.pokedex.data.remote.response.pokemone_list

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)