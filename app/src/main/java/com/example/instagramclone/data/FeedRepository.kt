package com.example.instagramclone.data

import com.example.libinstaclone.ImgurClient
import com.example.libinstaclone.modules.Data
import com.example.libinstaclone.modules.Image
import com.example.libinstaclone.params.Section

class FeedRepository {

    //Calling api from the Link{@libInstaClone}
    val api = ImgurClient.api // TODO: return a proper error if Null

    //Returns getGallery method with hot of API
    suspend fun getHotFeed(): List<Image>? {
        val response = api.getGallery(Section.HOT)
        return response.body()?.image
    }

    //Returns getGallery method with top section of API
    suspend fun getTopFeed(): List<Image>? {
        val response = api.getGallery(Section.TOP)
        return response.body()?.image
    }

}

