package com.nfc.newsapp.data.di

import com.nfc.newsapp.BuildConfig
import com.nfc.newsapp.data.network.NewsApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule
{
    @Singleton
    @Provides
    fun provideRetrofit(): NewsApiInterface {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiInterface::class.java)

    }

}