package com.example.soccernews.feature.news.data.remote.service

import com.example.soccernews.feature.news.data.remote.model.NewsResponse
import retrofit2.http.GET

interface NewsService {
    @GET("news.json")
    suspend fun getNews(): List<NewsResponse>
}