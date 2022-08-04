package com.example.soccernews.feature.favorites.presentantion

import com.example.soccernews.feature.news.domain.model.NewsModel

sealed class FavoriteNewsViewState {
    data class FavoriteList(val favoriteNewsList: List<NewsModel>) : FavoriteNewsViewState()
}