package com.nfc.newsapp.data.Response

data class Response(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)