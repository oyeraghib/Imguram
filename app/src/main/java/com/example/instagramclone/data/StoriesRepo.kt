package com.example.instagramclone.data

import com.example.libinstaclone.ImgurClient
import com.example.libinstaclone.modules.Image
import com.example.libinstaclone.modules.Tag

class StoriesRepo {

    //Calling api from the Link{@libInstaClone}
    val api = ImgurClient.api

    //Returns getTags method with data having list of Tags
    suspend fun getTags(): List<Tag>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }

    //Returns getTagGallery which includes list of Images corresponding to the tag name
    suspend fun getTagGallery(tagName : String): List<Image>? {
        val response = api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}