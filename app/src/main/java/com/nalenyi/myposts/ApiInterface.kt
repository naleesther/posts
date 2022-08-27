package com.nalenyi.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts():retrofit2.Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId")postId: Int): Call<Post>

    @GET("/posts/{postId/comments}")
    fun getComments(@Path("postId")commentsId: Int): Call<List<Comment>>

}