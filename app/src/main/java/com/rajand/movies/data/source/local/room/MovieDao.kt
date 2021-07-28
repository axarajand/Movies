package com.rajand.movies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities WHERE category = :category")
    fun getMovies(category: String): DataSource.Factory<Int, MovieEntity>

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getFavoritedMovies(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE id = :id")
    fun getSeriesWithEpisodeById(id: Int): LiveData<SeriesWithEpisode>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM episodeentities WHERE seriesId = :seriesId")
    fun getEpisodesBySeriesId(seriesId: Int): LiveData<List<EpisodeEntity>>

    @Query("SELECT * FROM episodeentities WHERE episodeId = :episodeId")
    fun getEpisodeById(episodeId: Int): LiveData<EpisodeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisodes(episodes: List<EpisodeEntity>)

    @Update
    fun updateEpisode(episode: EpisodeEntity)

}