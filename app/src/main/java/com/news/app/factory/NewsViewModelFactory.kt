package com.news.app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.news.app.util.UIEventManager
import com.news.app.viewmodel.NewsViewModel

/**
 * Created by Atif Qamar on 12-11-2020.
 */
class NewsViewModelFactory(private val eventManager: UIEventManager) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(
                eventManager
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}