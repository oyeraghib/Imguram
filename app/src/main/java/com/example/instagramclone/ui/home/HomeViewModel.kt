package com.example.instagramclone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.data.StoriesRepo
import com.example.libinstaclone.modules.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    //Instance of the repo
    private val repo = StoriesRepo()

    //Mutable Data for updating values within the class
    private val _tags = MutableLiveData<List<Tag>>()

    //Immutable live data for observing from Activity
    val tags: LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch(Dispatchers.IO
    ) {
        _tags.postValue(repo.getTags())

    }

}