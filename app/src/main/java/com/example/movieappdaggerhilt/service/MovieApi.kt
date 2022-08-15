package com.example.movieappdaggerhilt.service

import com.example.movieappdaggerhilt.models.Movies
import com.example.movieappdaggerhilt.util.Util
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET(Util.END_POINT)
    suspend fun getMovie(): Response<Movies>
}