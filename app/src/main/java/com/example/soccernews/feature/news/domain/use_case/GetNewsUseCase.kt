package com.example.soccernews.feature.news.domain.use_case

import com.example.soccernews.feature.news.domain.model.NewsModel
import com.example.soccernews.feature.news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(private val repository: NewsRepository) {
    operator fun invoke(): Flow<List<NewsModel>> = repository.getNews()
}