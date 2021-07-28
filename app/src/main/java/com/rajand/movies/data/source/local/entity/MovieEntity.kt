package com.rajand.movies.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "genres")
        var genres: String,

        @ColumnInfo(name = "realese")
        var realese: String,

        @ColumnInfo(name = "rating")
        var rating: Double,

        @ColumnInfo(name = "favorited")
        var favorited: Boolean = false,

        @ColumnInfo(name = "imagePath")
        var imagePath: String,

        @ColumnInfo(name = "category")
        var category: String
)
