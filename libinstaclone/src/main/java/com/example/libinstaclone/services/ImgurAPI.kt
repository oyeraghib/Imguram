package com.example.libinstaclone.services

import com.example.libinstaclone.modules.GalleryResponse
import com.example.libinstaclone.modules.TagsResponse
import com.example.libinstaclone.modules.tagResponse.TagResponse
import com.example.libinstaclone.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ImgurAPI {


    @GET("gallery/{section}")

     suspend fun getGallery(
        @Path("section") section: Section? = Section.HOT,
        @Query("album_preview") albumPreview: Boolean? = true
     ) : Response<GalleryResponse>

    @GET("tags")
    suspend fun getTags() : Response<TagsResponse>

    @GET("gallery/t/{tagName}")
    suspend fun getTag(
        @Path("tagName")tagName : String
    ) : Response<TagResponse>
}