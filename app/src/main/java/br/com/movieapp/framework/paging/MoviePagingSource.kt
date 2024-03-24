package br.com.movieapp.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.features.moviepopular.data.mapper.toMovieItem
import br.com.movieapp.features.moviepopular.domain.source.MoviePopularRemoteDataSource
import br.com.movieapp.framework.domain.model.MovieItem
import okio.IOException
import retrofit2.HttpException

// The maximum number of items to be fetched in one page
private const val LIMIT = 20

/**
 * A [PagingSource] that uses the [MoviePopularRemoteDataSource] to get the data.
 *
 * @property remoteDataSource The data source this paging source uses to get the data.
 */
class MoviePagingSource(
    private val remoteDataSource: MoviePopularRemoteDataSource
) : PagingSource<Int, MovieItem>() {

    /**
     * Get the key for the page that was most recently accessed.
     *
     * @param state The current [PagingState].
     * @return The key of the page that was most recently accessed.
     */
    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    /**
     * Load a page of data.
     *
     * @param params The parameters for the load operation.
     * @return The result of the load operation, which includes the page of data and the keys for the adjacent pages.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        return try {
            val pageNumber = params.key ?: 1
            val response = remoteDataSource.getPopularMovies(pageNumber)
            val movies = response.movieList
            LoadResult.Page(
                data = movies.toMovieItem(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )

        } catch (e: IOException) {
            e.printStackTrace()
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}