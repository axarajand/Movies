@file:Suppress("DEPRECATION")

package com.rajand.movies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.rajand.movies.data.source.local.LocalDataSource
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.data.source.remote.RemoteDataSource
import com.rajand.movies.utils.*
import com.rajand.movies.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].id
    private val seriesResponses = DataDummy.generateRemoteDummySeries()
    private val seriesId = seriesResponses[0].id
    private val episodeResponses = DataDummy.generateRemoteDummyEpisodes()
    private val episodeId = episodeResponses[0].id

    @Test
    fun testGetAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun testGetAllSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllSeries()).thenReturn(dataSourceFactory)
        movieRepository.getAllSeries()

        val seriesEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummySeries()))
        verify(local).getAllSeries()
        assertNotNull(seriesEntities.data)
        assertEquals(seriesResponses.size.toLong(), seriesEntities.data?.size?.toLong())
    }

    @Test
    fun testGetFavoriteSeries() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllSeries()).thenReturn(dataSourceFactory)
        movieRepository.getAllSeries()

        val seriesEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummySeries()))
        verify(local).getAllSeries()
        assertNotNull(seriesEntities.data)
        assertEquals(seriesResponses.size.toLong(), seriesEntities.data?.size?.toLong())
    }

    @Test
    fun testGetMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovieById(movieId)).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getMovie(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieEntity)
        assertEquals(movieResponses[0].title, movieEntity.title)
    }

    @Test
    fun testGetSeriesWithEpisodes() {
        val dummyEntity = MutableLiveData<SeriesWithEpisode>()
        dummyEntity.value = DataDummy.generateDummySeriesWithEpisodes(DataDummy.generateDummySeries()[0], false)
        `when`(local.getSeriesWithEpisodes(seriesId)).thenReturn(dummyEntity)

        val seriesEntities = LiveDataTestUtil.getValue(movieRepository.getSeries(seriesId))
        verify(local).getSeriesWithEpisodes(seriesId)
        assertNotNull(seriesEntities.data)
        assertNotNull(seriesEntities.data?.mSeries?.title)
        assertEquals(seriesResponses[0].name, seriesEntities.data?.mSeries?.title)
    }

    @Test
    fun testGetAllEpisodesBySeries() {
        val dummyEpisodes = MutableLiveData<List<EpisodeEntity>>()
        dummyEpisodes.value = DataDummy.generateDummyEpisodes(seriesId)
        `when`(local.getAllEpisodesBySeries(seriesId)).thenReturn(dummyEpisodes)

        val seriesEntities = LiveDataTestUtil.getValue(movieRepository.getAllEpisodes(seriesId))
        verify(local).getAllEpisodesBySeries(seriesId)
        assertNotNull(seriesEntities.data)
        assertEquals(episodeResponses.size.toLong(), seriesEntities.data?.size?.toLong())
    }

    @Test
    fun testGetEpisode() {
        val dummyEpisode = MutableLiveData<EpisodeEntity>()
        dummyEpisode.value = DataDummy.generateDummyEpisodes(seriesId)[0]
        `when`(local.getEpisodeWithContent(episodeId)).thenReturn(dummyEpisode)

        val episodeEntity = LiveDataTestUtil.getValue(movieRepository.getEpisode(episodeId))
        verify(local).getEpisodeWithContent(episodeId)
        assertNotNull(episodeEntity)
        assertEquals(episodeResponses[0].name, episodeEntity.title)
    }

}