package com.nalenyi.myposts

import android.telecom.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    fun getPosts():retrofit2.Call<List<Post>>

}