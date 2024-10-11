package com.learn.domain.usecases

import com.learn.domain.model.Movie
import com.learn.domain.repository.MovieRepository

class GetNowPlayingUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(page: Int): Result<List<Movie>> {
        return repository.getNowPlayingMovies(page)
    }
}

/*
Explanation:
Use Cases: Promote separation of concerns by handling specific actions or business rules
Operator function: Allows the use case to be called like a function
*/