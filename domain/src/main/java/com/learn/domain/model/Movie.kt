package com.learn.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String?,
    val genreIds: List<Int>,
    val releaseDate: String?,
    val voteAverage: Double,
    val voteCount: Int
)
