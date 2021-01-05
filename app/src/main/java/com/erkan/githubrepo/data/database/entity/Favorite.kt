package com.erkan.githubrepo.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by umiterkan on 1/3/2021
 */



@Entity(tableName = "favorite_table")
class Favorite(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "repo_name") val repo_name: String

)
