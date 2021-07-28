@file:Suppress("DEPRECATION")

package com.rajand.movies.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(movieRepository)
    }

    @Test
    fun testGetSeries() {
        val dummySeries = Resource.success(pagedList)
        `when`(dummySeries.data?.size).thenReturn(11)
        val series = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        series.value = dummySeries

        `when`(movieRepository.getAllSeries()).thenReturn(series)
        val seriesEntities = viewModel.getSeries().value?.data
        verify(movieRepository).getAllSeries()
        assertNotNull(seriesEntities)
        assertEquals(11, seriesEntities?.size)

        viewModel.getSeries().observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }

}