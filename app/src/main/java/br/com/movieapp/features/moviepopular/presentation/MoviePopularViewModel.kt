package br.com.movieapp.features.moviepopular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import br.com.movieapp.features.moviepopular.domain.usecase.GetMoviesPopularUseCase
import br.com.movieapp.features.moviepopular.presentation.state.MoviePopularState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val getMoviesPopularUseCase: GetMoviesPopularUseCase
) : ViewModel() {

    var uiState by mutableStateOf(MoviePopularState())
        private set

    init {
        getMoviesPopular()

    }

    private fun getMoviesPopular() {
        val movies = getMoviesPopularUseCase().cachedIn(viewModelScope)
        uiState = uiState.copy(movies = movies)
    }
}