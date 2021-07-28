package com.rajand.movies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.vo.Resource

class TVShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getSeries(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getAllSeries()

}