package com.nalenyi.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APiClient {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }



}