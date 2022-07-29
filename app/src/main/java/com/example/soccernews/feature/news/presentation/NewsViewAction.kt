package com.example.soccernews.feature.news.presentation

sealed class NewsViewAction {
    data class ShowToast(val message: String) : NewsViewAction()
}