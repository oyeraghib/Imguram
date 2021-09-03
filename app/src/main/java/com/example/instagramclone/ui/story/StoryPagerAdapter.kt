package com.example.instagramclone.ui.story

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import coil.request.ImageRequest
import com.example.instagramclone.databinding.PageItemStoryBinding
import com.example.libinstaclone.modules.Image
import java.lang.Exception

class StoryPagerAdapter() :
    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallBack()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    private class StoryDiffCallBack: DiffUtil.ItemCallback<Image> (){
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {

        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater, parent, false)

        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {

        val image = getItem(position)
        val imgURL = if(image?.isAlbum == true && image?.imagesCount != 0) {
            image.images!![0].link!!
        } else {
            image.link
        }

        imgURL.let {
            holder.binding.ivStory.load(imgURL)
            holder.binding.tvStory.text = imgURL
        }

        cacheNext(position, holder.binding.ivStory)


    }

    private fun cacheNext(position: Int, imageView: ImageView) {

        val image = try{
            getItem(position + 1)
        } catch (e: Exception) {
            null
        }

        val imgUrl = if(image?.isAlbum == true && image?.imagesCount != 0){
            image.images!![0].link!!
        } else {
            image?.link
        }

        imgUrl?.let {
            val request = ImageRequest.Builder(imageView.context)
                .data(imgUrl)
                .build()

            Coil.imageLoader(imageView.context).enqueue(request)
        }
    }
}