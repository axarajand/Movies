package com.rajand.movies.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SeriesResponse(

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("genre_ids")
	val genreIds: String,

	@field:SerializedName("poster_path")
	val posterPath: String
)
