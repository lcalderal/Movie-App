package br.com.movieapp.features.moviepopular.data.mapper

import br.com.movieapp.framework.data.remote.response.MovieItemResponse
import br.com.movieapp.framework.domain.model.MovieItem
import br.com.movieapp.framework.util.toPostUrl

fun List<MovieItemResponse>.toMovieItem() = map { movie ->
    MovieItem(
        id = movie.id,
        title = movie.title,
        voteAverage = movie.voteAverage,
        imageUrl = movie.posterPath.toPostUrl() ?: ""
    )
}