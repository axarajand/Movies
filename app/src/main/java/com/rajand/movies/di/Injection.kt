package com.rajand.movies.di

import android.content.Context
import com.rajand.movies.data.MovieRepository
import com.rajand.movies.data.source.local.LocalDataSource
import com.rajand.movies.data.source.local.room.MovieDatabase
import com.rajand.movies.data.source.remote.RemoteDataSource
import com.rajand.movies.utils.AppExecutors
import com.rajand.movies.utils.api.ApiHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}