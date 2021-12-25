package com.example.videostreamingapplication.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videostreamingapplication.model.JsonResponseWeHave
import com.example.videostreamingapplication.repository.VideoRepo
import kotlinx.coroutines.launch
import retrofit2.Response

class VideoViewModel(private var repository : VideoRepo) : ViewModel() {

    val videoResponse : MutableLiveData<Response<JsonResponseWeHave>> = MutableLiveData()

    fun getVideoDetail(){
        viewModelScope.launch {
            val response = repository.getVideoData()
            Log.d("VideoViewModel"  , " we are here $response")
            videoResponse.value =  response
        }
    }


}