package com.example.libinstaclone.services

import com.example.libinstaclone.modules.GalleryResponse
import com.example.libinstaclone.modules.TagsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET


interface ImgurAPI {


    @GET("gallery/hot?album_preview=true")
     suspend fun getGallery() : Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags() : Response<TagsResponse>
}