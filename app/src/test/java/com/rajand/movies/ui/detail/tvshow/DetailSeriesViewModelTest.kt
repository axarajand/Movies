@file:Suppress("DEPRECATION")

package com.rajand.movies.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.utils.DataDummy
import com.rajand.movies.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailSeriesViewModelTest {

    private lateinit var viewModel: DetailSeriesViewModel
    private val dummySeries = DataDummy.generateDummySeries()[0]
    private val seriesId = dummySeries.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var seriesObserver: Observer<Resource<SeriesWithEpisode>>

    @Before
    fun setUp() {
        viewModel = DetailSeriesViewModel(movieRepository)
        viewModel.setSelectedSeries(seriesId)
    }

    @Test
    fun getSeriesWithEpisode() {
        val dummySeriesWithEpisode = Resource.success(DataDummy.generateDummySeriesWithEpisodes(dummySeries, true))
        val series = MutableLiveData<Resource<SeriesWithEpisode>>()
        series.value = dummySeriesWithEpisode
        `when`(movieRepository.getSeries(seriesId)).thenReturn(series)
        viewModel.seriesEpisode.observeForever(seriesObserver)
        verify(seriesObserver).onChanged(dummySeriesWithEpisode)
    }

}