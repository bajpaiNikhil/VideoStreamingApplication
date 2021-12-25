package com.example.videostreamingapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.videostreamingapplication.R
import com.example.videostreamingapplication.model.Video
import kotlinx.android.synthetic.main.each_video_item.view.*
import java.util.concurrent.RecursiveAction
import kotlin.coroutines.coroutineContext

class VideoListAdapter( private val VideoList : List<Video> , val listener :(Video) -> Unit) : RecyclerView.Adapter<VideoListAdapter.ItemAdapter>() {
    class ItemAdapter(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_video_item , parent , false)
        return ItemAdapter(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter, position: Int) {
        val currentItem = VideoList[position]

        holder.itemView.videoNameTV.text = currentItem.title

        holder.itemView.setOnClickListener{
            listener(currentItem)
        }
        Log.d("VideoListAdapter" , currentItem.thumb)
        Glide.with(holder.itemView).load(currentItem.thumb).into(holder.itemView.videoIV)

    }

    override fun getItemCount(): Int {
        return VideoList.size
    }
}