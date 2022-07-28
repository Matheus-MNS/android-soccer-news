package com.example.soccernews.feature.news.data.local

import com.example.soccernews.common.data.local.NewsDao
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsLocalDataSource(private val newsDao: NewsDao) {
    fun insertFavoriteNews(newsModel: NewsModel): Flow<Unit> = flow {
        emit(
            newsDao.insertFavoriteNews(newsModel)
        )
    }
}