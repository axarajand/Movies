package com.rajand.movies.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.*

@Entity(
    tableName = "episodeentities",
    primaryKeys = ["episodeId", "seriesId"],
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["id"],
        childColumns = ["seriesId"]
    )],
    indices = [Index(value = ["episodeId"]),
        Index(value = ["seriesId"])]
)
data class EpisodeEntity(
    @NonNull
    @ColumnInfo(name = "episodeId")
    var episodeId: Int,

    @NonNull
    @ColumnInfo(name = "seriesId")
    var seriesId: Int,

    @NonNull
    @ColumnInfo(name = "episodeNumber")
    var episodeNumber: Int,

    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @NonNull
    @ColumnInfo(name = "description")
    var description: String,

    @NonNull
    @ColumnInfo(name = "realese")
    var realese: String,

    @NonNull
    @ColumnInfo(name = "rating")
    var rating: Double,

    @NonNull
    @ColumnInfo(name = "watch")
    var watch: Boolean = false
)
