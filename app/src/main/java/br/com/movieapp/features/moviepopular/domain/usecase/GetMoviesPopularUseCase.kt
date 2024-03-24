package br.com.movieapp.features.moviepopular.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.movieapp.features.moviepopular.domain.repository.MoviePopularRepository
import br.com.movieapp.framework.domain.model.MovieItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val LIMIT_ITEMS = 20

class GetMoviesPopularUseCase @Inject constructor(
    private val repository: MoviePopularRepository
){
    operator fun invoke(): Flow<PagingData<MovieItem>> {
        return repository.getPopularMovies(
            pagingConfig = PagingConfig(
                pageSize = LIMIT_ITEMS,
                initialLoadSize = LIMIT_ITEMS
            )
        )
    }
}