package com.learn.tmdbmovies.ui.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.learn.tmdbmovies.viewmodels.MovieViewModel

@Composable
fun MovieListScreen(
    viewModel: MovieViewModel = hiltViewModel()
) {
    val movies by viewModel.movies.collectAsState()
    LazyColumn {
        this.items(movies) { movie ->
            MovieItem(movie)
        }
    }
}

/*
Explanation:
hiltViewModel() :  Provides the ViewModel instance via Hilt
collectAsState() : Collects the StateFlow as a Compose State
 */