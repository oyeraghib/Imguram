package com.example.libinstaclone

import com.example.libinstaclone.params.Section
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurAPITest {

    private val api = ImgurClient.api


    @Test
    fun `get Gallery -hot response`() {


        runBlocking {
            val resp = api.getGallery(Section.HOT)
            assertNotNull(resp.body())
        }
    }

    @Test
    fun `get Gallery -top response`() {


        runBlocking {
            val resp = api.getGallery(Section.TOP)
            assertNotNull(resp.body()?.image?.size)
        }
    }


    @Test
    fun `get Tag -aww response`() {

        runBlocking {
            val resp = api.getTag("aww")
            assertNotNull(resp.body()?.data)
        }
    }


    @Test
    fun `get Tags response`() {


        runBlocking {
            val resp = api.getTags()
            assertNotNull(resp.body())
        }
    }

}

