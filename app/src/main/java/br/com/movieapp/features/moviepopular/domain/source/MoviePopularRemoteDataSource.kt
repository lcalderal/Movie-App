package br.com.movieapp.features.moviepopular.domain.source

import br.com.movieapp.framework.data.remote.response.MovieResponse
import br.com.movieapp.framework.paging.MoviePagingSource

interface MoviePopularRemoteDataSource {
    suspend fun getPopularMovies(page: Int): MovieResponse
    fun getPopularMoviesPagingSource(): MoviePagingSource
}