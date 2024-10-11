package com.learn.data.repository

import com.learn.data.mappers.toDomainModel
import com.learn.data.remote.TMDBApiService
import com.learn.domain.model.Genre
import com.learn.domain.model.Movie
import com.learn.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val apiService: TMDBApiService,
    private val apiKey: String
): MovieRepository {
    override suspend fun getNowPlayingMovies(page: Int): Result<List<Movie>> {
        return try {
            val response = apiService.getNowPlaying(apiKey, page =page)
            val movies = response.results.map {
                it.toDomainModel()
            }
            Result.success(movies)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPopularMovies(page: Int): Result<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTopRatedMovies(page: Int): Result<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUpcomingMovies(page: Int): Result<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMoviesByGenre(genreId: Int, page: Int): Result<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMoviesGenre(): Result<List<Genre>> {
        TODO("Not yet implemented")
    }

}

/*
Explanation :
Exception Handling: Wraps network calls in try-catch to handle exceptions and return a Result
Mapping: Converts DTOs to domain models before returning.
 */