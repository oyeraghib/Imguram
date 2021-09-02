package com.example.instagramclone.ui.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramclone.data.StoriesRepo
import com.example.libinstaclone.modules.Gallery
import com.example.libinstaclone.modules.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel: ViewModel() {

private val repo = StoriesRepo()

    private val _tags = MutableLiveData<List<Tag>>()

    val tags: LiveData<List<Tag>> = _tags

    fun fetchTags() = viewModelScope.launch(Dispatchers.IO
    ) {
        _tags.postValue(repo.getTags())

    }

}