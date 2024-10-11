package com.learn.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
    @SerializedName("results")
    val results: List<MovieDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

/*
DTOs: Used by retrofit to parse JSON responses. They should match the APIs data structure
SerializedName: Ensures the JSON keys are correctly mapped to Kotlin properties.
*/
