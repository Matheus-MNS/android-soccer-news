package com.example.soccernews.feature.news.di

import com.example.soccernews.feature.news.data.remote.data_source.NewsRemoteDataSource
import com.example.soccernews.feature.news.data.remote.service.NewsService
import com.example.soccernews.feature.news.data.repository.NewsRepositoryImpl
import com.example.soccernews.feature.news.domain.use_case.GetNewsUseCase
import com.example.soccernews.feature.news.presentation.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val newsModule = module {
    viewModel {
        NewsViewModel(
            getNewsUseCase = GetNewsUseCase(
                repository = NewsRepositoryImpl(
                    newsRemoteDataSource = NewsRemoteDataSource(
                        service = get<Retrofit>().create(NewsService::class.java)
                    )
                )
            )
        )
    }
}