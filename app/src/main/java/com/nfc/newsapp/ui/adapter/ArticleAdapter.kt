package com.nfc.newsapp.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nfc.newsapp.R
import com.nfc.newsapp.data.Response.Article
import com.nfc.newsapp.data.Response.Response
import com.nfc.newsapp.databinding.ArticleItemLayoutBinding
import com.nfc.newsapp.ui.click.ArticleClick

class ArticleAdapter(var context: Context, var click:ArticleClick): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var articleList = mutableListOf<Article>()

    inner class ArticleViewHolder(private var articleItemLayoutBinding: ArticleItemLayoutBinding):
        RecyclerView.ViewHolder(articleItemLayoutBinding.root)
    {
        fun bind (article: List<Article>, i: Int) = with(articleItemLayoutBinding)
        {
            articleTitle2.text = article[i].title
            articleDesc2.text = article[i].description
            articleSource.text = article[i].source.name

            Glide.with(context).load(article[i].urlToImage)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(articleImg2)

            articleItemLayoutBinding.root.setOnClickListener {
                click.onCLick(article[i])
            }

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder
    {
        return ArticleViewHolder(
            ArticleItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int)
    {
        //holder.bind(articleList,position)
        holder.bind(differ.currentList,position)


    }

    private val differCallback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return  oldItem.content == newItem.content
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)
}