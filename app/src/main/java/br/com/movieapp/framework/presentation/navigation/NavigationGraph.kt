package br.com.movieapp.framework.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {
        }
        composable(BottomNavItem.SearchMovie.route) {
        }
        composable(BottomNavItem.MovieFavorite.route) {
        }
    }
}