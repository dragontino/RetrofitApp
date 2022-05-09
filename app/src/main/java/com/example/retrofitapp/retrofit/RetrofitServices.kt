package com.example.retrofitapp.retrofit

import com.example.retrofitapp.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    suspend fun getMovieList(): MutableList<Movie>
}