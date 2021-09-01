package com.example.instagramclone

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclone.databinding.ActivityMainBinding
import com.example.instagramclone.ui.stories.StoriesViewModel
import com.example.libinstaclone.modules.Gallery

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStory.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        setupNav()
        storiesViewModel.fetchTags()

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

        storiesViewModel.tags.observe({lifecycle}) {
            binding.rvStory
        }

    }
}


