package com.example.instagramclone.ui.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    //view model
    private  val storyViewModel by viewModels<StoryViewModel>()
    //view binding
    private lateinit var binding: ActivityStoryBinding

    //initialising adapter
    private val storyPagerAdapter = StoryPagerAdapter()

    private val handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")

        tagName?.let {
            storyViewModel.fetchTagGallery(it)
        }
        binding.vpStory.adapter = storyPagerAdapter

        binding.vpStory.registerOnPageChangeCallback(pageChangeCallback)

    }

    private val nextPageRunnable = Runnable {
        binding.vpStory.currentItem++
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            binding.progressView.scaleX = 0F
            binding.progressView.animate().cancel()
            binding.progressView.animate().scaleX(1F).setDuration(5000).setStartDelay(10).start()
            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable, 5000)

        }
    }
    override fun onResume() {
        super.onResume()

        storyViewModel.images.observe({lifecycle}) {
            storyPagerAdapter.submitList(it)

        }
    }
}