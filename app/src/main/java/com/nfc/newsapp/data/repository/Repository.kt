package com.nfc.newsapp.data.repository

import com.nfc.newsapp.data.network.NewsApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiInterface: NewsApiInterface) {

    fun getArticles(country:String):Flow<Response<com.nfc.newsapp.data.Response.Response>>
    = flow {
        val result = apiInterface.getArticles(country)
        emit(result)
    }.flowOn(Dispatchers.IO)
}