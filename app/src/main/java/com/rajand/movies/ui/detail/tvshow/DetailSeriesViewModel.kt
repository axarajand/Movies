package com.rajand.movies.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.SeriesWithEpisode
import com.rajand.movies.vo.Resource

class DetailSeriesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val seriesId = MutableLiveData<Int>()

    fun setSelectedSeries(seriesId: Int) {
        this.seriesId.value = seriesId
    }

    var seriesEpisode: LiveData<Resource<SeriesWithEpisode>> = Transformations.switchMap(seriesId) { mSeriesId ->
        movieRepository.getSeries(mSeriesId)
    }

    fun setFavorite() {
        val episodeResource = seriesEpisode.value
        if (episodeResource != null) {
            val seriesWithEpisode = episodeResource.data
            if (seriesWithEpisode != null) {
                val seriesEntity = seriesWithEpisode.mSeries
                val newState = !seriesEntity.favorited
                movieRepository.setMovieFavorite(seriesEntity, newState)
            }
        }
    }

}