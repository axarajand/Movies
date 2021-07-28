package com.rajand.movies.ui.reader

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.vo.Resource

class SeriesReaderViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var seriesId = MutableLiveData<Int>()
    private var episodeId = MutableLiveData<Int>()

    fun setSelectedSeries(seriesId: Int) {
        this.seriesId.value = seriesId
    }

    fun setSelectedEpisode(episodeId: Int) {
        this.episodeId.value = episodeId
    }

    var episodes: LiveData<Resource<List<EpisodeEntity>>> = Transformations.switchMap(seriesId) { mSeriesId ->
        movieRepository.getAllEpisodes(mSeriesId)
    }

    var selectedEpisode: LiveData<EpisodeEntity> = Transformations.switchMap(episodeId) { selectedPosition ->
        movieRepository.getEpisode(selectedPosition)
    }

    fun watchEpisode(episode: EpisodeEntity) {
        movieRepository.setWatchEpisode(episode)
    }

    fun getEpisodeSize(): Int {
        if (episodes.value != null) {
            val episodeEntities = episodes.value?.data
            if (episodeEntities != null) {
                return episodeEntities.size
            }
        }
        return 0
    }

    fun setNextPage() {
        if (selectedEpisode.value != null && episodes.value != null) {
            val episodeEntity = selectedEpisode.value
            val episodeEntities = episodes.value?.data
            if (episodeEntity != null && episodeEntities != null) {
                val position = episodeEntity.episodeNumber
                if (position < episodeEntities.size && position >= 1) {
                    episodeId.value = episodeEntities[position + 0].episodeId
                }
            }
        }
    }

    fun setPrevPage() {
        if (selectedEpisode.value != null && episodes.value != null) {
            val episodeEntity = selectedEpisode.value
            val episodeEntities = episodes.value?.data
            if (episodeEntity != null && episodeEntities != null) {
                val position = episodeEntity.episodeNumber
                if (position < episodeEntities.size && position >= 1) {
                    episodeId.value = episodeEntities[position - 2].episodeId
                }
            }
        }
    }
}