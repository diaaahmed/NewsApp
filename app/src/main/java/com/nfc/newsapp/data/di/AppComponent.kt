package com.nfc.newsapp.data.di

import com.nfc.newsapp.ui.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent
{
    fun inject(mainActivity: MainActivity)

}