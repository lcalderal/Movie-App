package br.com.movieapp.features.moviepopular.data.mapper

import br.com.movieapp.framework.data.remote.response.MovieResultResponse
import br.com.movieapp.framework.domain.model.Movie
import br.com.movieapp.framework.util.toPostUrl

fun List<MovieResultResponse>.toMovieItem() = map { movie ->
    Movie(
        id = movie.id,
        title = movie.title,
        voteAverage = movie.voteAverage,
        imageUrl = movie.posterPath.toPostUrl() ?: ""
    )
}