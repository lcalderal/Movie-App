package br.com.movieapp.framework.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object MoviePopular : BottomNavItem(
        title = "Filmes Populares",
        icon = Icons.Default.Movie,
        route = "movie_popular_screen"
    )

    object SearchMovie : BottomNavItem(
        title = "Pesquisar",
        icon = Icons.Default.Search,
        route = "search_movie_screen"
    )

    object MovieFavorite : BottomNavItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite,
        route = "movie_favorite_screen"
    )
}