package com.learn.tmdbmovies.di

import com.learn.data.remote.TMDBApiService
import com.learn.data.repository.MovieRepositoryImpl
import com.learn.domain.repository.MovieRepository
import com.learn.domain.usecases.GetNowPlayingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiKey(): String = "9e67393e51297a35255b2fc49bb5faf2"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        apiService: TMDBApiService,
        apiKey: String
    ): MovieRepository {
        return MovieRepositoryImpl(
            apiService, apiKey
        )
    }

    @Provides
    @Singleton
    fun provideGetNowPlayingMoviesUseCase(
        repository: MovieRepository
    ): GetNowPlayingUseCase {
        return GetNowPlayingUseCase(repository)
    }

}

/*
@Module: and @Provides : Tell Hilt how to provide instances of classes
SingletonComponent: Indicates that the provided instances live as long as the application.
*/

