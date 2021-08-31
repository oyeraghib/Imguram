package com.example.instagramclone.ui.feed

import android.util.Log
import androidx.lifecycle.*
import com.example.instagramclone.data.FeedRepository
import com.example.libinstaclone.modules.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {

    private val repo = FeedRepository()

    private val _feed = MutableLiveData<List<Image>>()

    val feed: LiveData<List<Image>> = _feed

    fun updateFeed(feedType: String) {

        viewModelScope.launch ( Dispatchers.IO ) {

            when(feedType){

                "hot" -> _feed.postValue(repo.getHotFeed())
                "top" -> _feed.postValue(repo.getTopFeed())

                else -> Log.e("FEED", "Feed type has to be hot or top")

            }
        }

    }
}