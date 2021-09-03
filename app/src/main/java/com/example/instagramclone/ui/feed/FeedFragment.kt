package com.example.instagramclone.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.request.ImageRequest
import com.example.instagramclone.R
import com.example.instagramclone.databinding.FragmentFeedBinding

class FeedFragment: Fragment() {

    private val feedViewModel: FeedViewModel by viewModels()
    private lateinit var _binding: FragmentFeedBinding

    private var feedAdapter = FeedRecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let { feedViewModel.updateFeed(it) }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        _binding = FragmentFeedBinding.inflate(inflater, container, false)
        _binding.rvFeed.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvFeed.adapter = feedAdapter

        feedViewModel.feed.observe(viewLifecycleOwner) {

            it.forEach { image->

                val request = ImageRequest.Builder(requireContext())
                    .data("\"https://i.imgur.com/${image.cover}.jpg\"")
                    .size(_binding.rvFeed.width)
                    .build()
                Coil.imageLoader(requireContext()).enqueue(request)

            }

            feedAdapter.submitList(it)
        }

        return _binding.root
    }
}

