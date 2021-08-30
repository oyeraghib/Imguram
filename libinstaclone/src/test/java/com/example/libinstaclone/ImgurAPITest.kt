package com.example.libinstaclone

import com.example.libinstaclone.services.ImgurAPI
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurAPITest {


    @Test
    fun `get Gallery response`() {


        runBlocking {
            val resp = ImgurClient().api.getGallery()
            assertNotNull(resp.body())
        }
    }
    @Test
    fun `get Tags response`() {


        runBlocking {
            val resp = ImgurClient().api.getTags()
            assertNotNull(resp.body())
        }
    }



}

