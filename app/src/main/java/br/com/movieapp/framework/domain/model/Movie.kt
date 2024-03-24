package br.com.movieapp.framework.domain.model

data class Movie(
    val page: Int = 0,
    val movieList: List<MovieItem> = listOf(),
    val totalPages: Int = 0,
    val totalMovies: Int = 0
)
