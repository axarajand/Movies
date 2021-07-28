package com.rajand.movies.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val MOVIE = "Movies"
    const val TV_SHOW = "TV Show"

    fun getSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM movieentities WHERE favorited = 1 ")
        if (filter == MOVIE) {
            simpleQuery.append("ORDER BY category ASC")
        } else if (filter == TV_SHOW) {
            simpleQuery.append("ORDER BY category DESC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}