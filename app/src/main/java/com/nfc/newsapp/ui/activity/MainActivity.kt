package com.nfc.newsapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.nfc.newsapp.R
import com.nfc.newsapp.data.di.MainApp
import com.nfc.newsapp.data.repository.Repository
import com.nfc.newsapp.databinding.ActivityMainBinding
import com.nfc.newsapp.ui.viewmodel.ArticleViewModel
import com.nfc.newsapp.ui.viewmodel.ArticleViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val ui by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var articleViewModel: ArticleViewModel

    @Inject
    lateinit var articleViewModelFactory: ArticleViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        (application as MainApp).component.inject(this)

        //val articleViewModelFactory = ArticleViewModelFactory(repository)

        articleViewModel = ViewModelProvider(this,articleViewModelFactory)[ArticleViewModel::class.java]

        articleViewModel.getArticles("eg")

        articleViewModel.articleResponse.observe(this) {
            if(it.isSuccessful)
            {
                val title = it.body()!!.articles[0].title

                Toast.makeText(this, "Title $title", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

            }
        }
    }
}