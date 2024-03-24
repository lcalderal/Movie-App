package br.com.movieapp.features.moviepopular.data.source

import br.com.movieapp.features.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.framework.data.remote.response.MovieResponse
import br.com.movieapp.framework.data.remote.service.MovieService
import br.com.movieapp.framework.paging.MoviePagingSource

class MoviePopularRemoteDataSourceImpl(
    private val service: MovieService
) : MoviePopularRemoteDataSource {
    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page)
    }

    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }
}