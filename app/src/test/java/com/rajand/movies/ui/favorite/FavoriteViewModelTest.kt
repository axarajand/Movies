@file:Suppress("DEPRECATION")

package com.rajand.movies.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.utils.SortUtils
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
class FavoriteViewModelTest {

    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun testGetFavorites() {
        val dummySeries = pagedList
        `when`(dummySeries.size).thenReturn(11)
        val series = MutableLiveData<PagedList<MovieEntity>>()
        series.value = dummySeries

        `when`(movieRepository.getFavoriteSeries(SortUtils.TV_SHOW)).thenReturn(series)
        val seriesEntities = viewModel.getFavorites(SortUtils.TV_SHOW).value
        verify(movieRepository).getFavoriteSeries(SortUtils.TV_SHOW)
        assertNotNull(seriesEntities)
        assertEquals(11, seriesEntities?.size)

        viewModel.getFavorites(SortUtils.TV_SHOW).observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }

}