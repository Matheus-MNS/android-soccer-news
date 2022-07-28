package com.example.soccernews.common.di

import com.example.soccernews.common.data.local.NewsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val commonModule = module {
    factory {
        NewsDatabase.getDatabase(
            context = androidApplication()
        ).newsDao()
    }
}