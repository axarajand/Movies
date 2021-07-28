package com.rajand.movies.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rajand.movies.data.source.local.LocalDataSource
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.data.source.remote.ApiResponse
import com.rajand.movies.data.source.remote.RemoteDataSource
import com.rajand.movies.data.source.remote.response.EpisodeResponse
import com.rajand.movies.data.source.remote.response.MovieResponse
import com.rajand.movies.data.source.remote.response.SeriesResponse
import com.rajand.movies.utils.AppExecutors
import com.rajand.movies.utils.Const
import com.rajand.movies.utils.SortUtils
import com.rajand.movies.vo.Resource

class FakeMovieRepository constructor(private val remoteDataSource: RemoteDataSource,
                                  private val localDataSource: LocalDataSource,
                                  private val appExecutors: AppExecutors
)
    : MovieDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                data.forEach { response ->
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.genreIds,
                        response.releaseDate,
                        response.voteAverage,
                        false,
                        response.posterPath,
                        Const.CATEGORY_MOVIE
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllSeries(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<SeriesResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllSeries(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<SeriesResponse>>> =
                remoteDataSource.getAllSeries()

            public override fun saveCallResult(data: List<SeriesResponse>) {
                val seriesList = ArrayList<MovieEntity>()
                data.forEach { response ->
                    val series = MovieEntity(
                        response.id,
                        response.name,
                        response.overview,
                        response.genreIds,
                        response.firstAirDate,
                        response.voteAverage,
                        false,
                        response.posterPath,
                        Const.CATEGORY_SERIES
                    )
                    seriesList.add(series)
                }
                localDataSource.insertMovies(seriesList)
            }
        }.asLiveData()
    }

    override fun getAllEpisodes(seriesId: Int): LiveData<Resource<List<EpisodeEntity>>> {
        return object : NetworkBoundResource<List<EpisodeEntity>, List<EpisodeResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<EpisodeEntity>> =
                localDataSource.getAllEpisodesBySeries(seriesId)

            override fun shouldFetch(data: List<EpisodeEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<EpisodeResponse>>> =
                remoteDataSource.getAllEpisodes(seriesId)

            override fun saveCallResult(data: List<EpisodeResponse>) {
                val episodeList = ArrayList<EpisodeEntity>()
                data.forEach { response ->
                    val episode = EpisodeEntity(
                        response.id,
                        seriesId,
                        response.episodeNumber,
                        response.name,
                        response.overview,
                        response.airDate,
                        response.voteAverage
                    )
                    episodeList.add(episode)
                }
                localDataSource.insertEpisodes(episodeList)
            }
        }.asLiveData()
    }

    override fun getFavoriteSeries(sort: String): LiveData<PagedList<MovieEntity>> {
        val query = SortUtils.getSortedQuery(sort)
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoritedMovies(query), config).build()
    }

    override fun getMovie(movieId: Int): LiveData<MovieEntity> =
        localDataSource.getMovieById(movieId)

    override fun getSeries(seriesId: Int): LiveData<Resource<SeriesWithEpisode>> {
        return object : NetworkBoundResource<SeriesWithEpisode, List<EpisodeResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<SeriesWithEpisode> =
                localDataSource.getSeriesWithEpisodes(seriesId)

            override fun shouldFetch(data: SeriesWithEpisode?): Boolean =
                data?.mEpisodes == null || data.mEpisodes.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<EpisodeResponse>>> =
                remoteDataSource.getAllEpisodes(seriesId)

            override fun saveCallResult(data: List<EpisodeResponse>) {
                val episodeList = ArrayList<EpisodeEntity>()
                data.forEach { response ->
                    val episode = EpisodeEntity(
                        response.id,
                        seriesId,
                        response.episodeNumber,
                        response.name,
                        response.overview,
                        response.airDate,
                        response.voteAverage)
                    episodeList.add(episode)
                }
                localDataSource.insertEpisodes(episodeList)
            }
        }.asLiveData()
    }

    override fun getEpisode(episodeId: Int): LiveData<EpisodeEntity> =
        localDataSource.getEpisodeWithContent(episodeId)

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setWatchEpisode(episode: EpisodeEntity) =
        appExecutors.diskIO().execute { localDataSource.setWatchEpisode(episode) }

}
