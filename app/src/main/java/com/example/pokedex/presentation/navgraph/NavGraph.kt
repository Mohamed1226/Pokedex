package com.example.pokedex.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedex.presentation.navgraph.Routes.pokemonDetailsScreen
import com.example.pokedex.presentation.navgraph.Routes.pokemonListScreen


@Composable
fun NavGraph() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = pokemonListScreen) {
        composable(route = pokemonListScreen) {
            /// my compose
        }
        composable(route = "$pokemonDetailsScreen/{pokemonColor}/{pokemonName}", arguments = listOf(
            navArgument(
                name = "pokemonColor"
            ) {
                type = NavType.IntType
            },
            navArgument(
                name = "pokemonName"
            ) {
                type = NavType.StringType
            }
        )) {
            val color = remember {
                it.arguments?.getInt("pokemonColor")?.let { color ->
                    Color(color)
                } ?: Color.White
            }

            val name = remember {
                it.arguments?.getString("pokemonName")
            }

            /// my compose
        }
    }
}
