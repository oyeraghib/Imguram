package com.example.instagramclone.data

import com.example.libinstaclone.ImgurClient
import com.example.libinstaclone.modules.Image
import com.example.libinstaclone.modules.Tag

class StoriesRepo {

    val api = ImgurClient.api

    suspend fun getTags(): List<Tag>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getTagGallery(tagName : String): List<Image>? {
        val response = api.getTagGallery(tagName)
        return response.body()?.data?.items
    }
}