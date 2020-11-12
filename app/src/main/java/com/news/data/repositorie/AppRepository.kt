package com.news.data.repositorie

import com.news.app.constants.ConstantsApp
import com.news.app.model.News
import com.news.data.network.ApiService
import com.news.data.network.RetrofitInstance

/**
 * Created by Atif Qamar on 12-11-2020.
 */

class AppRepository {
    private var service: ApiService = RetrofitInstance.appService
    suspend fun getNews(): News = service.getNews(ConstantsApp.countryCode, ConstantsApp.apiKey)
}