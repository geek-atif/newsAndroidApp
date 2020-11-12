package com.news.app.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.news.R
import com.news.app.model.Article
import com.news.app.view.adapter.AdapterNew.AdapterNewHolder
import com.news.app.viewmodel.NewsViewModel
import com.news.databinding.ContentItemBinding
import com.squareup.picasso.Picasso

/**
 * Created by Atif Qamar on 12-11-2020.
 */

internal class AdapterNew(
    private val articles: List<Article>,
    private val newsViewModel: NewsViewModel
) : RecyclerView.Adapter<AdapterNewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterNewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ContentItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.content_item, parent, false)
        return AdapterNewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterNewHolder, position: Int) {
        val article = articles[position]
        holder.setBinding(article, newsViewModel)
        Picasso.get()
            .load(article.urlToImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            //.resize(400, 160)
            .into(holder.binding.imImage)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    internal inner class AdapterNewHolder(var binding: ContentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setBinding(
            article: Article?,
            newsViewModel: NewsViewModel?
        ) {
            binding.newsArticle = article
            binding.viewModel = newsViewModel
            binding.executePendingBindings()
        }
    }
}