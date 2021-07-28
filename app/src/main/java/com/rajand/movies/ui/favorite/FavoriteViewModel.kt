package com.rajand.movies.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity

class FavoriteViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getFavorites(sort: String) : LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteSeries(sort)

    fun setFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorited
        movieRepository.setMovieFavorite(movieEntity, newState)
    }

}