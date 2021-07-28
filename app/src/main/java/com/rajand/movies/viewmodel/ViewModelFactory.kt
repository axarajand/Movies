package com.rajand.movies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.di.Injection
import com.rajand.movies.ui.detail.movie.DetailMovieViewModel
import com.rajand.movies.ui.detail.tvshow.DetailSeriesViewModel
import com.rajand.movies.ui.favorite.FavoriteViewModel
import com.rajand.movies.ui.movie.MovieViewModel
import com.rajand.movies.ui.reader.SeriesReaderViewModel
import com.rajand.movies.ui.tvshow.TVShowViewModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                return TVShowViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailSeriesViewModel::class.java) -> {
                return DetailSeriesViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(SeriesReaderViewModel::class.java) -> {
                return SeriesReaderViewModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class: " + modelClass.name)
        }
    }

}