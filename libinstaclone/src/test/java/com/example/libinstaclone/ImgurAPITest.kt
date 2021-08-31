package com.example.libinstaclone

import com.example.libinstaclone.params.Section
import com.example.libinstaclone.services.ImgurAPI
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurAPITest {


    @Test
    fun `get Gallery -hot response`() {

        val api = ImgurClient.api

        runBlocking {
            val resp = ImgurClient.api.getGallery(Section.HOT)
            assertNotNull(resp.body())
        }
    }

    @Test
    fun `get Gallery -top response`() {

        val api = ImgurClient.api

        runBlocking {
            val resp = ImgurClient.api.getGallery(Section.TOP)
            assertNotNull(resp.body())
        }
    }


    @Test
    fun `get Tags response`() {


        runBlocking {
            val resp = ImgurClient.api.getTags()
            assertNotNull(resp.body())
        }
    }

}

