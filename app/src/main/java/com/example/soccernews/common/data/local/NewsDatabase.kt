package com.example.soccernews.common.data.local

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.soccernews.feature.news.domain.model.NewsModel

@Database(entities = [NewsModel::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {


    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getDatabase(context: Context): NewsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}