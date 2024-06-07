package com.chinhdev.lab6_kot104.Lab8

import com.chinhdev.lab6_kot104.model.Movie
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MovieService {
    @GET("/books")
    suspend fun getListFilms(): Response<List<MovieResponse>>
    @POST("/books")
    suspend fun addFilms(@Body movie: MovieResponse)
}