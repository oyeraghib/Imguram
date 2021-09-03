package com.example.instagramclone.ui

import android.app.Application
import android.graphics.ImageDecoder
import android.graphics.Insets.add
import android.os.Build.VERSION.SDK_INT
import android.telecom.Call
import coil.Coil
import coil.Coil.setImageLoader
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

class InstaCloneApp: Application() {

    override fun onCreate() {
        super.onCreate()

        Coil.setImageLoader(ImageLoader.Builder(this@InstaCloneApp)
            .componentRegistry {
                if (SDK_INT >= 28){
                    add(ImageDecoderDecoder(this@InstaCloneApp))
                } else {
                            add(GifDecoder())
                }
            }
            .build())

    }
}