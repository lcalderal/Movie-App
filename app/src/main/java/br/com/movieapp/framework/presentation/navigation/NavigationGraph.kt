package br.com.movieapp.framework.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.movieapp.features.moviepopular.presentation.MoviePopularScreen
import br.com.movieapp.features.moviepopular.presentation.MoviePopularViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {
            val viewModel: MoviePopularViewModel = hiltViewModel()

            MoviePopularScreen(
                uiState = viewModel.uiState,
                navigateToDetailMovie = {}
            )
        }
        composable(BottomNavItem.SearchMovie.route) {
        }
        composable(BottomNavItem.MovieFavorite.route) {
        }
    }
}