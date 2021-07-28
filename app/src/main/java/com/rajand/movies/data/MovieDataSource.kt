package com.rajand.movies.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.vo.Resource

interface MovieDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllSeries(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getAllEpisodes(seriesId: Int): LiveData<Resource<List<EpisodeEntity>>>

    fun getFavoriteSeries(sort: String): LiveData<PagedList<MovieEntity>>

    fun getMovie(movieId: Int): LiveData<MovieEntity>

    fun getSeries(seriesId: Int): LiveData<Resource<SeriesWithEpisode>>

    fun getEpisode(episodeId: Int): LiveData<EpisodeEntity>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setWatchEpisode(episode: EpisodeEntity)
}