package com.example.videostreamingapplication.api

import com.example.videostreamingapplication.model.JsonResponseWeHave
import retrofit2.Response
import retrofit2.http.GET

interface VideoApi {

    @GET("/bikashthapa01/myvideos-android-app/master/data.json")
    suspend fun getVideoData(): Response<JsonResponseWeHave>



}