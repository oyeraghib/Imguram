package com.example.libinstaclone

import com.example.libinstaclone.services.ImgurAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ImgurClient {

    companion object {
        const val BASE_URL = "https://api.imgur.com/3/"
        const val API_KEY = "05190a2220d229e"
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor{
            val request = it.request().newBuilder()
                .addHeader("Authorization", "Client-ID 05190a2220d229e")
                .build()

                it.proceed(request)
        }
        .build()


    val retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.imgur.com/3/")
        .build()

    val api = retrofit.create(ImgurAPI::class.java
    )
}