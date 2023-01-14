package com.nfc.newsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nfc.newsapp.data.repository.Repository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ArticleViewModel (private var repository: Repository): ViewModel()
{
    private val _articleResponse: MutableLiveData<Response<com.nfc.newsapp.data.Response.Response>>
    = MutableLiveData()

    val articleResponse: LiveData<Response<com.nfc.newsapp.data.Response.Response>>
    get() = _articleResponse

    fun getArticles(country:String)
    {
        viewModelScope.launch {
            repository.getArticles(country)
                .catch { Log.d("TAG", "getArticle error: ${it.message}") }
                .buffer()
                .collect{
                        _articleResponse.value = it
                }
        }

//        viewModelScope.launch {
//            repository.getArticles(country)
//                .catch { Log.d("TAG", "getArticle error: ${it.message}") }
//                .buffer()
//                .collect{
//                    if(it.isSuccessful)
//                    {
//                        _articleResponse.value = it
//                    }
//                    else
//                    {
//                        Log.d("TAG", "Erooor: ${it.message()}")
//                    }
//                }
//        }
    }
}