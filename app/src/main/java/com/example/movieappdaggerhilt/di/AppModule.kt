package com.example.movieappdaggerhilt.di

import com.example.movieappdaggerhilt.service.MovieApi
import com.example.movieappdaggerhilt.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl()= Util.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL:String):MovieApi=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
}