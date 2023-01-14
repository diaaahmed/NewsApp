package com.nfc.newsapp.data.di

import android.app.Application

class MainApp : Application()
{
    lateinit var component:AppComponent

    override fun onCreate()
    {
        super.onCreate()

        component = DaggerAppComponent.create()
    }
}