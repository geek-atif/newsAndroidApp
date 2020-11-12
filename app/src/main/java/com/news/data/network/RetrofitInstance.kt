package com.news.data.network

import com.google.gson.GsonBuilder
import com.news.app.constants.ConstantsApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Atif Qamar on 12-11-2020.
 */
object RetrofitInstance {
    val appService: ApiService by lazy {
        Retrofit.Builder()
                .baseUrl(ConstantsApp.baseURL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(ApiService::class.java)
    }
}