@file:Suppress("DEPRECATION")

package com.rajand.movies.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
        viewModel.setSelectedMovies(movieId)
    }

    @Test
    fun testGetMovie() {
        val movie = MutableLiveData<MovieEntity>()
        val resource = dummyMovie
        movie.value = resource
        `when`(movieRepository.getMovie(movieId)).thenReturn(movie)

        val observer = Mockito.mock(Observer::class.java) as Observer<MovieEntity>
        viewModel.movie.observeForever(observer)
        verify(observer).onChanged(resource)
    }
}