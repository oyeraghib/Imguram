package com.example.instagramclone.ui.story

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.libinstaclone.modules.tagResponse.Image

class StoryPagerAdapter(diffCallback: DiffUtil.ItemCallback<Image>) :
    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(diffCallback) {

    class StoryPageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class StoryDiffCallBack: DiffUtil.ItemCallback<Image> (){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}