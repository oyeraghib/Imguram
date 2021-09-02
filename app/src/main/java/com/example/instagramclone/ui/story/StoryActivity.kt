package com.example.instagramclone.ui.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private  val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var binding: ActivityStoryBinding

    private val storyPagerAdapter = StoryPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")

        tagName?.let {
            storyViewModel.fetchTagGallery(it)
        }

        binding.vpStory.adapter = storyPagerAdapter


    }

    override fun onResume() {
        super.onResume()

        storyViewModel.images.observe({lifecycle}){
            storyPagerAdapter.submitList(it)

        }
    }
}