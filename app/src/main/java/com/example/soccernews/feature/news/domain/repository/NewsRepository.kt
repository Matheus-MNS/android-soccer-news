package com.example.soccernews.feature.news.domain.repository

import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(): Flow<List<NewsModel>>

    fun insertNews(newsModel: NewsModel): Flow<Unit>

}