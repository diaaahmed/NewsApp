package com.nfc.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nfc.newsapp.data.repository.Repository
import javax.inject.Inject

class ArticleViewModelFactory @Inject constructor(private val repository: Repository): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleViewModel(repository) as T
    }
}