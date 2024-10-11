package com.learn.domain.model

data class TVShow(
    val id: Int,
    val name: String,
    val overview: String,
    val posterUrl: String?,
    val genreIds: List<Int>,
    val firstAirDate: String?,
    val voteAverage: Double,
    val voteCount: Int
)
