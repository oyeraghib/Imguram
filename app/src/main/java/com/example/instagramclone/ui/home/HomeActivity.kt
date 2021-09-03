package com.example.instagramclone.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.instagramclone.R
import com.example.instagramclone.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

    private val storiesAdapter = StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStory.apply { layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        adapter = storiesAdapter

        }


        setupNav()
        homeViewModel.fetchTags()

    }

        fun setupNav() {
            val navView: BottomNavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_activity_main)

            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.

            /*
            NOTE: Not using action bar in the app as of now
            ----------------------ACTION BAR CODE------------------------------

            setupActionBarWithNavController(navController, appBarConfiguration)
             */

            navView.setupWithNavController(navController)

        }


    override fun onResume() {
        super.onResume()
        homeViewModel.tags.observe({ lifecycle }) {

            it.forEach{ gallery ->

                val request = ImageRequest.Builder(this)
                    .data("\"https://i.imgur.com/${gallery.backgroundHash}.jpg\"")
                    .size(resources.getDimensionPixelSize(R.dimen.story_head_dimen_size))
                    .build()

                Coil.imageLoader(this).enqueue(request)
            }
                storiesAdapter.submitList(it)
            }

    }
}


