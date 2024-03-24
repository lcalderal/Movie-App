package br.com.movieapp.features.moviepopular.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.features.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.features.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.framework.domain.model.MovieItem
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : MoviePopularRepository {
    override fun getPopularMovies(pagingConfig: PagingConfig): Flow<PagingData<MovieItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { remoteDataSource.getPopularMoviesPagingSource() }
        ).flow
    }
}