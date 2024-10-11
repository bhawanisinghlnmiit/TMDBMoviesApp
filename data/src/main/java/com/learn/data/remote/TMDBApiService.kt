package com.learn.data.remote

import com.learn.data.model.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApiService {
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("language") language: String="en-US",
        @Query("page") page: Int = 1
    ): MovieResponseDto
}

/*
Explanation:

@GET Annotation: Specifies the HTTP method and endpoint.
suspend Functions: Enable the use of coroutines for asynchronous calls.

* */