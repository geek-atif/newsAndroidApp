package com.news.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.news.R
import com.news.app.constants.ConstantsApp
import com.news.app.factory.NewsViewModelFactory
import com.news.app.model.Article
import com.news.app.util.UIEventManager
import com.news.app.view.activity.NewsDescriptionActivity
import com.news.app.view.adapter.AdapterNew
import com.news.app.viewmodel.NewsViewModel
import com.news.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Atif Qamar on 12-11-2020.
 */

class MainActivity : AppCompatActivity(), UIEventManager {
    private lateinit var newViewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModelFactory = NewsViewModelFactory(this)
        newViewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)
        binding.lifecycleOwner = this
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        loadData()
    }

    private fun loadData() {
        newViewModel.loadDataFromAPI().observe(this, Observer {
            binding.recyclerViewMain.adapter = AdapterNew(it.articles, newViewModel)
        })
    }

    override fun showToast(text: String) {
        Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
        shimmer_view_container.stopShimmerAnimation()
    }

    override fun showProgressBar() {
        binding.shimmerViewContainer.visibility = View.VISIBLE
        binding.recyclerViewMain.visibility = View.GONE
    }

    override fun hideProgressBar() {
        binding.recyclerViewMain.visibility = View.VISIBLE
        binding.shimmerViewContainer.visibility = View.GONE
    }

    override fun onItemClick(article: Article) {
        var intent = Intent(this, NewsDescriptionActivity::class.java)
        intent.putExtra(ConstantsApp.imageURL, article.urlToImage);
        intent.putExtra(ConstantsApp.webURL, article.url);
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        //  binding.shimmerViewContainer.stopShimmerAnimation()
        super.onPause()
    }
}