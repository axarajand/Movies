package com.rajand.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllMovies()

}