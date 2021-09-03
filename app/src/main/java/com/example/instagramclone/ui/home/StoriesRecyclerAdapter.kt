package com.example.instagramclone.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.instagramclone.databinding.ListItemStoryBinding
import com.example.instagramclone.ui.story.StoryActivity
import com.example.libinstaclone.modules.Tag


class StoriesRecyclerAdapter () :

    ListAdapter<Tag, StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {

    class StoriesViewHolder(val binding: ListItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallBack: DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = (oldItem === newItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {

        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryBinding.inflate(inflater, parent, false)

        return StoriesViewHolder(binding)
        }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {

        val gallery = getItem(position)
        holder.binding.tvStoryIcon.text = gallery.displayName.toString()
        holder.binding.ivStoryIcon.load("https://i.imgur.com/${gallery.backgroundHash}.jpg")
        holder.binding.root.apply {
            setOnClickListener{
                context.startActivity(
                    Intent(context, StoryActivity::class.java).apply {
                        putExtra("tag", gallery.name)

                    }
                )
            }
        }
    }
}