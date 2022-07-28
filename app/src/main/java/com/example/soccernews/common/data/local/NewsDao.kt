package com.example.soccernews.common.data.local

import androidx.room.*
import com.example.soccernews.feature.news.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow
@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsModel WHERE favorite = 1")
    fun getNewsList(): Flow<List<NewsModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteNews(news: NewsModel)


}