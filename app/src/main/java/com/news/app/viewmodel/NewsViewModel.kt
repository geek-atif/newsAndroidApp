package com.news.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.news.app.model.Article
import com.news.app.util.UIEventManager
import com.news.data.repositorie.AppRepository
import java.io.IOException

/**
 * Created by Atif Qamar on 12-11-2020.
 */

class NewsViewModel(private val eventManager: UIEventManager) : ViewModel() {
    private val repository = AppRepository()
    fun loadDataFromAPI() = liveData {
        try {
            eventManager.showProgressBar()
            val receivedData = repository.getNews()
            eventManager.hideProgressBar()
            emit(receivedData)
        } catch (e: IOException) {
            eventManager.showToast(e.message.toString())
            eventManager.hideProgressBar()
        } catch (e: Exception) {
            e.printStackTrace()
            eventManager.showToast("Exception")
            eventManager.hideProgressBar()
        }
    }

    fun itemClicked(article: Article) {
        eventManager.onItemClick(article)
    }
}