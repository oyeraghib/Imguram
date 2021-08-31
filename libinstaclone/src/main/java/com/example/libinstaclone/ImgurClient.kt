package com.example.libinstaclone

import com.example.libinstaclone.converter.EnumConverterFactory
import com.example.libinstaclone.services.ImgurAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ImgurClient {

        const val BASE_URL = "https://api.imgur.com/3/"
        const val API_KEY = "05190a2220d229e"


    private val httpClient: OkHttpClient by lazy {


        OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization", "Client-ID $API_KEY")
                    .build()

                it.proceed(request)
            }

            .build()
    }


    val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(EnumConverterFactory())
            .baseUrl("$BASE_URL")
            .build()
    }

        val api: ImgurAPI by lazy {
            retrofit.create(ImgurAPI::class.java
            )
        }
    }
