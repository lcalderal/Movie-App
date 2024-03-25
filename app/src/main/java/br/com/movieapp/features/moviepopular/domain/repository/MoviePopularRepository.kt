package br.com.movieapp.features.moviepopular.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.framework.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviePopularRepository {
    fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<Movie>>
}