package br.com.movieapp.framework.domain.model

data class MovieDetails(
    val id: Int,
    val title: String,
    val genres: List<String> = emptyList(),
    val overview: String = "",
    val backdropPathUrl: String = "",
    val releaseDate: String = "",
    val voteAverage: Double = 0.0,
    val duration: Int = 0,
    val imageUrl: String = "",
    val voteCount: Int = 0
)
