package com.rajand.movies.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SeriesWithEpisode(
    @Embedded
    var mSeries: MovieEntity,

    @Relation(parentColumn = "id", entityColumn = "seriesId")
    var mEpisodes: List<EpisodeEntity>
)