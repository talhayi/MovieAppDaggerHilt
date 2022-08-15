package com.example.movieappdaggerhilt.repository

import com.example.movieappdaggerhilt.service.MovieApi
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {
    suspend fun getMovie() = movieApi.getMovie()
}