package com.rajand.movies.ui.reader

interface SeriesReaderCallback {
    fun moveTo(position: Int, seriesId: Int)
}