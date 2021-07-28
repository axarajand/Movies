package com.rajand.movies.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rajand.movies.data.source.remote.response.*
import com.rajand.movies.utils.EspressoIdlingResource
import com.rajand.movies.utils.api.ApiHelper

class RemoteDataSource private constructor(private val apiHelper: ApiHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: ApiHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        resultMovies.value = ApiResponse.success(apiHelper.loadMovies())
        if (!EspressoIdlingResource.idlingResource.isIdleNow) {
            EspressoIdlingResource.decrement()
        }
        return resultMovies
    }

    fun getAllSeries(): LiveData<ApiResponse<List<SeriesResponse>>> {
        EspressoIdlingResource.increment()
        val resultSeries = MutableLiveData<ApiResponse<List<SeriesResponse>>>()
        resultSeries.value = ApiResponse.success(apiHelper.loadSeries())
        if (!EspressoIdlingResource.idlingResource.isIdleNow) {
            EspressoIdlingResource.decrement()
        }
        return resultSeries
    }

    fun getAllEpisodes(seriesId: Int): LiveData<ApiResponse<List<EpisodeResponse>>> {
        EspressoIdlingResource.increment()
        val resultEpisodes = MutableLiveData<ApiResponse<List<EpisodeResponse>>>()
        resultEpisodes.value = ApiResponse.success(apiHelper.loadEpisodes(seriesId))
        if (!EspressoIdlingResource.idlingResource.isIdleNow) {
            EspressoIdlingResource.decrement()
        }
        return resultEpisodes
    }

}