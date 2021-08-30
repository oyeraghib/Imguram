package com.example.libinstaclone.modules


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProcessingX(
    @Json(name = "status")
    val status: String?
)