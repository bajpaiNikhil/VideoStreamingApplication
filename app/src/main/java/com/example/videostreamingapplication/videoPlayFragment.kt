package com.example.videostreamingapplication

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import kotlinx.android.synthetic.main.fragment_video_play.*


class videoPlayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("videoUrl")
            param2 = it.getString("videoSubtitle")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_play, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("videoPlayFragment" , param1.toString())


        val uri = Uri.parse(param1)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(context)

        mediaController.setAnchorView(videoView)

        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()

    }
}