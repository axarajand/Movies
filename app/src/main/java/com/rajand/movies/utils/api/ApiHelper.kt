package com.rajand.movies.utils.api

import android.content.Context
import android.os.StrictMode
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANResponse
import com.rajand.movies.data.source.remote.response.EpisodeResponse
import com.rajand.movies.data.source.remote.response.MovieResponse
import com.rajand.movies.data.source.remote.response.SeriesResponse
import com.rajand.movies.utils.Const
import org.json.JSONArray
import org.json.JSONObject

class ApiHelper(private val context: Context) {

    fun loadMovies(): List<MovieResponse> {
        AndroidNetworking.initialize(context)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val listMovies = ArrayList<MovieResponse>()
        val url = "${Const.BASE_URL}/movie/popular?page=2&api_key=${Const.API_KEY}"
        val request = AndroidNetworking.get(url).build()

        val response: ANResponse<Any> = request.executeForJSONObject()
        if (response.isSuccess) {
            try {
                val responseObject = JSONObject(response.result.toString())
                val resultMovie = responseObject.getJSONArray("results")

                for (i in 0 until resultMovie.length()) {
                    val movie = resultMovie.getJSONObject(i)

                    val description = movie.getString("overview")
                    val releaseDate = movie.getString("release_date")
                    val rating = movie.getDouble("vote_average")
                    val id = movie.getInt("id")
                    val title = movie.getString("original_title")
                    val genresJson = movie.getJSONArray("genre_ids")
                    val imagePath = Const.IMAGE_URL + movie.getString("poster_path")

                    val genres = loadGenres(genresJson, "movie")

                    val movieResponse = MovieResponse(description, releaseDate, rating, id, title, genres, imagePath)
                    listMovies.add(movieResponse)
                }
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
            }
        } else {
            Log.d("Error", response.error.toString())
        }
        return listMovies
    }

    fun loadSeries(): List<SeriesResponse> {
        AndroidNetworking.initialize(context)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val listSeries = ArrayList<SeriesResponse>()
        val url = "${Const.BASE_URL}/tv/popular?page=1&api_key=${Const.API_KEY}"
        val request = AndroidNetworking.get(url).build()

        val response: ANResponse<Any> = request.executeForJSONObject()
        if (response.isSuccess) {
            try {
                val responseObject = JSONObject(response.result.toString())
                val resultSeries = responseObject.getJSONArray("results")

                for (i in 0 until resultSeries.length()) {
                    val series = resultSeries.getJSONObject(i)

                    val releaseDate = series.getString("first_air_date")
                    val description = series.getString("overview")
                    val rating = series.getDouble("vote_average")
                    val title = series.getString("name")
                    val id = series.getInt("id")
                    val genresJson = series.getJSONArray("genre_ids")
                    val imagePath = Const.IMAGE_URL + series.getString("poster_path")

                    val genres = loadGenres(genresJson, "tv")

                    val seriesResponse = SeriesResponse(releaseDate, description, rating, title, id, genres, imagePath)
                    listSeries.add(seriesResponse)
                }
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
            }
        } else {
            Log.d("Error", response.error.toString())
        }
        return listSeries
    }

    fun loadEpisodes(seriesId: Int): List<EpisodeResponse> {
        AndroidNetworking.initialize(context)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val listEpisodes = ArrayList<EpisodeResponse>()
        val url = "${Const.BASE_URL}/tv/${seriesId}/season/1?api_key=${Const.API_KEY}"
        val request = AndroidNetworking.get(url).build()

        val response: ANResponse<Any> = request.executeForJSONObject()
        if (response.isSuccess) {
            try {
                val responseObject = JSONObject(response.result.toString())
                val resultEpisodes = responseObject.getJSONArray("episodes")

                for (i in 0 until resultEpisodes.length()) {
                    val episode = resultEpisodes.getJSONObject(i)

                    val releaseDate = episode.getString("air_date")
                    val description = episode.getString("overview")
                    val episodeNumber = episode.getInt("episode_number")
                    val rating = episode.getDouble("vote_average")
                    val title = episode.getString("name")
                    val id = episode.getInt("id")

                    val episodeResponse = EpisodeResponse(releaseDate, description, episodeNumber, rating, title, id)
                    listEpisodes.add(episodeResponse)
                }
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
            }
        } else {
            Log.d("Error", response.error.toString())
        }
        return listEpisodes
    }

    private fun loadGenres(genres: JSONArray, show: String): String {
        AndroidNetworking.initialize(context)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val listGenres = ArrayList<String>()
        val url = "${Const.BASE_URL}/genre/${show}/list?api_key=${Const.API_KEY}"
        val request = AndroidNetworking.get(url).build()

        val response: ANResponse<Any> = request.executeForJSONObject()
        if (response.isSuccess) {
            try {
                val responseObject = JSONObject(response.result.toString())
                val resultGenre = responseObject.getJSONArray("genres")

                var index = 0
                for (i in 0 until resultGenre.length()) {
                    val genre = resultGenre.getJSONObject(i)

                    if (genre.getInt("id") == genres.get(index)) {
                        val name = genre.getString("name")
                        listGenres.add(name)
                        index++
                    }
                }
            } catch (e: Exception) {
                Log.d("Exception", e.message.toString())
            }
        } else {
            Log.d("Error", response.error.toString())
        }
        return listGenres.toString().replace("[", "").replace("]", "")
    }

}