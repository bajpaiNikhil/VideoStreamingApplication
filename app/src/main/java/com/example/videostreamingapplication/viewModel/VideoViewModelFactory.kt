package com.example.videostreamingapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.videostreamingapplication.repository.VideoRepo

class VideoViewModelFactory(private var repository : VideoRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideoViewModel(repository) as T
    }
}