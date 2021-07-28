@file:Suppress("DEPRECATION")

package com.rajand.movies.ui.reader

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.utils.DataDummy
import com.rajand.movies.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeriesReaderViewModelTest {

    private lateinit var viewModel: SeriesReaderViewModel

    private val dummySeries = DataDummy.generateDummySeries()[0]
    private val seriesId = dummySeries.id
    private val dummyEpisodes = DataDummy.generateDummyEpisodes(seriesId)
    private val episodeId = dummyEpisodes[0].episodeId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = SeriesReaderViewModel(movieRepository)
        viewModel.setSelectedSeries(seriesId)
        viewModel.setSelectedEpisode(episodeId)
    }

    @Test
    fun testGetEpisodes() {
        val episodes = MutableLiveData<Resource<List<EpisodeEntity>>>()
        val resource = Resource.success(dummyEpisodes) as Resource<List<EpisodeEntity>>
        episodes.value = resource
        `when`(movieRepository.getAllEpisodes(seriesId)).thenReturn(episodes)

        val observer = mock(Observer::class.java) as Observer<Resource<List<EpisodeEntity>>>
        viewModel.episodes.observeForever(observer)
        verify(observer).onChanged(resource)
    }

    @Test
    fun testSetSelectedEpisode() {
        val episode = MutableLiveData<EpisodeEntity>()
        val resource = dummyEpisodes[0]
        episode.value = resource
        `when`(movieRepository.getEpisode(episodeId)).thenReturn(episode)

        val observer = mock(Observer::class.java) as Observer<EpisodeEntity>
        viewModel.selectedEpisode.observeForever(observer)
        verify(observer).onChanged(resource)
    }

}