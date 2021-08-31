package com.example.instagramclone.data

import com.example.libinstaclone.ImgurClient
import com.example.libinstaclone.modules.Data
import com.example.libinstaclone.modules.Image
import com.example.libinstaclone.params.Section

class FeedRepository {

    val api = ImgurClient.api // TODO: return a proper error if Null

    suspend fun getHotFeed(): List<Image>? {
        val response = api.getGallery(Section.HOT)
        return response.body()?.image

        }


    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.image

    }





}

