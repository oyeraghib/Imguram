package com.example.instagramclone.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.data.StoriesRepo
import com.example.libinstaclone.modules.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {

    //instance of the repo
    private val repo = StoriesRepo()

    //Mutable live data for changing values within the class
    private val _images = MutableLiveData<List<Image>>()

    //Immutable data for observing the values outside the class
    val images: LiveData<List<Image>> = _images

    fun fetchTagGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO ) {
        _images.postValue(repo.getTagGallery(tagName))

    }
}