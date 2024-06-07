package com.chinhdev.lab6_kot104.Lab8

import com.chinhdev.lab6_kot104.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://66630a2662966e20ef0b19a2.mockapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val movieService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }

}