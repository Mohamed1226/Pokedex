package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pokedex.presentation.navgraph.NavGraph

import com.example.pokedex.ui.theme.JetpackComposePokedexTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Install the splash screen
        installSplashScreen().apply {
            //  setKeepOnScreenCondition {
            //  viewModel.showSplash
            // }
        }

        setContent {
            // Handle splash screen transition
            val splashVisible = remember { mutableStateOf(true) }

            LaunchedEffect(Unit) {
                delay(2000) // Simulate loading time
                splashVisible.value = false
            }

            if (!splashVisible.value) {

                JetpackComposePokedexTheme {
                    //control app bar colors
                    val isDarkMode = isSystemInDarkTheme()
                    val uiController = rememberSystemUiController()
                    SideEffect {
                        uiController.setSystemBarsColor(
                            color = Color.Transparent,
                            darkIcons = !isDarkMode
                        )

                    }
                    NavGraph()
                }
            }
        }
    }
}
