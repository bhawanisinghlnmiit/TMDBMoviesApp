package com.learn.domain.repository

import com.learn.domain.model.Genre
import com.learn.domain.model.Movie

interface MovieRepository {
    suspend fun getNowPlayingMovies(page: Int): Result<List<Movie>>
    suspend fun getPopularMovies(page: Int): Result<List<Movie>>
    suspend fun getTopRatedMovies(page: Int): Result<List<Movie>>
    suspend fun getUpcomingMovies(page: Int): Result<List<Movie>>
    suspend fun getMoviesByGenre(genreId: Int, page: Int): Result<List<Movie>>
    suspend fun getMoviesGenre(): Result<List<Genre>>
}

// Result<T> : Wraps the response to handle success and failure cases gracefully.
// Why Repositories as interfaces?: Allows for different implementations(e.g., network, cache)
// without changing the code that depends on them