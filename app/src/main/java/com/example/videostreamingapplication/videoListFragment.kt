package com.example.videostreamingapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videostreamingapplication.adapter.VideoListAdapter
import com.example.videostreamingapplication.model.JsonResponseWeHave
import com.example.videostreamingapplication.model.Video
import com.example.videostreamingapplication.repository.VideoRepo
import com.example.videostreamingapplication.viewModel.VideoViewModel
import com.example.videostreamingapplication.viewModel.VideoViewModelFactory
import kotlinx.android.synthetic.main.fragment_video_list.*
import retrofit2.Response


class videoListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
    }

    private fun setUpViewModel() {
        val videoViewModel = ViewModelProvider(this , VideoViewModelFactory(VideoRepo())).get(VideoViewModel::class.java)

        videoViewModel.getVideoDetail()
        videoViewModel.videoResponse.observe( viewLifecycleOwner , Observer {  response ->
            Log.d("VideoListFragment" , "we are from here ${response.body()}")
            if(response.isSuccessful){
                setUpRecyclerView(response)
            }else{
                Log.d("DetailActivity" , response.message())
            }
         })
    }

    private fun setUpRecyclerView(response: Response<JsonResponseWeHave>?) {
       //rView.layoutManager = LinearLayoutManager(context)
        rView.apply {
            layoutManager = LinearLayoutManager(context)
            fun onItemClicked(video: Video) {
                val bundle = bundleOf("videoUrl" to video.sources[0] , "videoSubtitel" to video.subtitle)
                findNavController().navigate(R.id.action_videoListFragment_to_videoPlayFragment , bundle)

            }
            adapter = VideoListAdapter(response?.body()!!.categories[0].videos , ::onItemClicked)
        }

    }
}