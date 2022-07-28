package com.example.soccernews.base_app

import android.app.Application
import com.example.soccernews.feature.favorites.di.favoritesModule
import com.example.soccernews.common.data.remote.di.dataRemoteModule
import com.example.soccernews.common.di.commonModule
import com.example.soccernews.feature.news.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    commonModule,
                    dataRemoteModule,
                    newsModule,
                    favoritesModule
                )
            ).androidContext(applicationContext)
        }
    }
}