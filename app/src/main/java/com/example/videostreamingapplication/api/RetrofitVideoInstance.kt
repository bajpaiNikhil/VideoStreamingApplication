package com.example.videostreamingapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitVideoInstance {
    private const val BASE_URL = "https://raw.githubusercontent.com/"


    private val retrofit by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : VideoApi by lazy{
        retrofit.create(VideoApi::class.java)
    }
}

