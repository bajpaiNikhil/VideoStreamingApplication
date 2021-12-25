package com.example.videostreamingapplication.repository

import com.example.videostreamingapplication.api.RetrofitVideoInstance
import com.example.videostreamingapplication.model.JsonResponseWeHave
import retrofit2.Response
import retrofit2.Retrofit


class VideoRepo{

    suspend fun getVideoData(): Response<JsonResponseWeHave> {
        return RetrofitVideoInstance.api.getVideoData()
    }
}