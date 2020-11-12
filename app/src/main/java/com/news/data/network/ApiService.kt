package com.news.data.network

import com.news.app.constants.ConstantsApp
import com.news.app.model.News
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Atif Qamar on 12-11-2020.
 */
interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNews(@Query("country") countryCode: String,
                        @Query("apiKey") apiKey: String ): News
}