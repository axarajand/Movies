package com.rajand.movies.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.MovieEntity

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val movieId = MutableLiveData<Int>()

    fun setSelectedMovies(movieId: Int) {
        this.movieId.value = movieId
    }

    var movie: LiveData<MovieEntity> = Transformations.switchMap(movieId) { mMovieId ->
        movieRepository.getMovie(mMovieId)
    }

    fun setFavorite() {
        val movie = movie.value
        if (movie != null) {
            val movieEntity = movie
            val newState = !movieEntity.favorited
            movieRepository.setMovieFavorite(movieEntity, newState)
        }
    }

}