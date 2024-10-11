package com.learn.data.mappers

import com.learn.data.model.MovieDto
import com.learn.domain.model.Movie

fun MovieDto.toDomainModel(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { "https://image.tmdb.org/t/p/w500$it" },
        genreIds = genreIds,
        releaseDate =releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

/*
Why Mappers? : Decouples the data layer from the domain layer, allowing changes in one without affecting the other
* */