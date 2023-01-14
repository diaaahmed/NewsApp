package com.nfc.newsapp.data.network

import com.nfc.newsapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface
{

    @GET("top-headlines")
    suspend fun getArticles(@Query("country") country:String,
    @Query("apiKey") apiKey:String = BuildConfig.API_KEY):Response<com.nfc.newsapp.data.Response.Response>
}