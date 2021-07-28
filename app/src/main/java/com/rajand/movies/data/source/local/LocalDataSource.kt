package com.rajand.movies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SupportSQLiteQuery
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.data.source.local.room.MovieDao
import com.rajand.movies.utils.Const

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies(Const.CATEGORY_MOVIE)

    fun getAllSeries(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies(Const.CATEGORY_SERIES)

    fun getMovieById(id: Int): LiveData<MovieEntity> = mMovieDao.getMovieById(id)

    fun getFavoritedMovies(sort: SupportSQLiteQuery): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoritedMovies(sort)

    fun getSeriesWithEpisodes(seriesId: Int): LiveData<SeriesWithEpisode> =
        mMovieDao.getSeriesWithEpisodeById(seriesId)

    fun getAllEpisodesBySeries(seriesId: Int): LiveData<List<EpisodeEntity>> =
        mMovieDao.getEpisodesBySeriesId(seriesId)

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun insertEpisodes(episodes: List<EpisodeEntity>) = mMovieDao.insertEpisodes(episodes)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mMovieDao.updateMovie(movie)
    }

    fun getEpisodeWithContent(episodeId: Int): LiveData<EpisodeEntity> =
        mMovieDao.getEpisodeById(episodeId)

    fun setWatchEpisode(episode: EpisodeEntity) {
        episode.watch = true
        mMovieDao.updateEpisode(episode)
    }
}