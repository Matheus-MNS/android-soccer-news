package com.example.soccernews.feature.favorites.domain

import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow

interface FavoritesNewsRepository{

    fun getFavoriteNews(): Flow<List<NewsModel>>
}

