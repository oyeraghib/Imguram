package com.example.instagramclone.data

import com.example.libinstaclone.ImgurClient
import com.example.libinstaclone.modules.Tag

class StoriesRepo {

    val api = ImgurClient.api

    suspend fun getTags(): List<Tag>? {
        val response = api.getTags()
        return response.body()?.data?.tags
    }
}