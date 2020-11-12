package com.news.app.util

import com.news.app.model.Article


/**
 * Created by Atif Qamar on 12-11-2020.
 */

interface UIEventManager {
    fun showToast(text: String)

    fun showProgressBar()

    fun hideProgressBar()

    fun onItemClick(article : Article)
}