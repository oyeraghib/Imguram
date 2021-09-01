package com.example.instagramclone.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ListItemFeedBinding
import com.example.libinstaclone.modules.Image

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {


    class FeedViewHolder(val binding: ListItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    class FeedDiffCallBack: DiffUtil.ItemCallback<Image>() {

        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem

        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.id == newItem.id

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemFeedBinding.inflate(inflater, parent, false)
        return FeedViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        val image = getItem(position)
        holder.binding.tvCaption.text = image.title.toString()
        holder.binding.ivImage.load("https://i.imgur.com/${image.cover}.jpg") {
            placeholder(R.drawable.ic_placeholder)
            error(R.drawable.ic_placeholder)
        }
    }
}