package com.erkan.githubrepo.data.database

import android.content.Context
import androidx.room.*
import com.erkan.githubrepo.data.database.dao.FavoriteDao
import com.erkan.githubrepo.data.database.entity.Favorite
import javax.inject.Inject

/**
 * Created by umiterkan on 1/3/2021
 */

@Database(entities = arrayOf(Favorite::class), version = 2, exportSchema = false)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun favoriteDao() : FavoriteDao
}