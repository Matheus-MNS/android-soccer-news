package com.example.soccernews.feature.favorites.data.local

import com.example.soccernews.common.data.local.NewsDao
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

class FavoritesNewsLocalDataSource(private val newsDao: NewsDao){

    fun  getFavoriteNews(): Flow<List<NewsModel>> =
        newsDao.getNewsList()
}