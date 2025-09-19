package com.mu54omd.sup.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mu54omd.sup.ui.screens.AboutScreen
import com.mu54omd.sup.ui.screens.ArticlesScreen
import com.mu54omd.sup.ui.screens.Screens
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Scaffold {
            NavHost(
                navController = navController,
                startDestination = Screens.ARTICLES.route
            ){
                composable(Screens.ARTICLES.route) {
                    ArticlesScreen(
                        onAboutButtonClick = { navController.navigate(Screens.ABOUT_DEVICE.route) },
                    )
                }
                composable(Screens.ABOUT_DEVICE.route) {
                    AboutScreen(
                        onBackButtonClick = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}