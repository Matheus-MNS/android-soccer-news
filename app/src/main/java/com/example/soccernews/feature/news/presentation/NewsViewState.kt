package com.example.soccernews.feature.news.presentation

import com.example.soccernews.feature.news.domain.model.NewsModel

sealed class NewsViewState {
    data class Success(val newsList: List<NewsModel>) : NewsViewState()
    data class Error(val message: String?) : NewsViewState()
}