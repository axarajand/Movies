package com.rajand.movies.ui.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rajand.movies.R
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.databinding.ActivityDetailMovieBinding
import com.rajand.movies.databinding.ContentDetailMovieBinding
import com.rajand.movies.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_series.*

class DetailMovieActivity : AppCompatActivity() {

    private var _activityDetailMovieBinding: ActivityDetailMovieBinding? = null
    private val activityDetailMovieBinding get() =  _activityDetailMovieBinding

    private var _detailContentBinding: ContentDetailMovieBinding? = null
    private val detailContentBinding get() =  _detailContentBinding

    private lateinit var viewModel: DetailMovieViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        _activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        _detailContentBinding = activityDetailMovieBinding?.detailContent
        setContentView(activityDetailMovieBinding?.root)

        setSupportActionBar(activityDetailMovieBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != 0) {
                activityDetailMovieBinding?.progressBar?.visibility = View.VISIBLE
                activityDetailMovieBinding?.nestedScrollView?.visibility = View.INVISIBLE

                viewModel.setSelectedMovies(movieId)
                viewModel.movie.observe(this, { movies ->
                    activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                    activityDetailMovieBinding?.nestedScrollView?.visibility = View.VISIBLE
                    populateMovie(movies)
                })
            }
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding?.tvTitleMovie?.text = movieEntity.title
        detailContentBinding?.tvGenresMovie?.text = movieEntity.genres
        detailContentBinding?.tvRealeseMovie?.text = movieEntity.realese
        detailContentBinding?.tvRatingMovie?.text = movieEntity.rating.toString()
        detailContentBinding?.tvDescriptionMovie?.text = movieEntity.description
        detailContentBinding?.imagePosterMovie?.let {
            Glide.with(this)
                .load(movieEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.movie.observe(this, { movie ->
            activityDetailMovieBinding?.progressBar?.visibility = View.VISIBLE
            if (movie != null) {
                activityDetailMovieBinding?.progressBar?.visibility = View.GONE
                val state = movie.favorited
                setFavoriteState(state)
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityDetailMovieBinding = null
        _detailContentBinding = null
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited_white)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

}