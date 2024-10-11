package com.learn.tmdbmovies.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.domain.model.Movie
import com.learn.domain.usecases.GetNowPlayingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val getNowPlayingUseCase: GetNowPlayingUseCase
): ViewModel(){
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()

    private var currentPage = 1

    init {
        fetchNowPlayingMovies()
    }

    private fun fetchNowPlayingMovies() {
        viewModelScope.launch {
            val result = getNowPlayingUseCase(currentPage)
            if(result.isSuccess) {
                val movies = result.getOrNull().orEmpty()
                _movies.value +=movies
                currentPage++
            } else {
                // Handle error
            }
        }
    }
}

/*
StateFlow: Emits a continuous stream of data updates.
viewModelScope: Ensures coroutines are cancelled when the viewmodel is cleared.
Dependency injection: @Injects to receive dependencies
 */

