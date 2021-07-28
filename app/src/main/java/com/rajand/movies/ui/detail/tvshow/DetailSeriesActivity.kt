package com.rajand.movies.ui.detail.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rajand.movies.R
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.databinding.ActivityDetailSeriesBinding
import com.rajand.movies.databinding.ContentDetailSeriesBinding
import com.rajand.movies.ui.reader.SeriesReaderActivity
import com.rajand.movies.viewmodel.ViewModelFactory
import com.rajand.movies.vo.Status
import kotlinx.android.synthetic.main.activity_detail_series.*

class DetailSeriesActivity : AppCompatActivity() {

    private var _activityDetailSeriesBinding: ActivityDetailSeriesBinding? = null
    private val activityDetailSeriesBinding get() =  _activityDetailSeriesBinding

    private var _detailContentBinding: ContentDetailSeriesBinding? = null
    private val detailContentBinding get() =  _detailContentBinding

    private lateinit var viewModel: DetailSeriesViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _activityDetailSeriesBinding = ActivityDetailSeriesBinding.inflate(layoutInflater)
        _detailContentBinding = activityDetailSeriesBinding?.detailContent
        setContentView(activityDetailSeriesBinding?.root)

        setSupportActionBar(activityDetailSeriesBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailSeriesAdapter()

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailSeriesViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val seriesId = extras.getInt(EXTRA_SERIES)
            if (seriesId != 0) {
                viewModel.setSelectedSeries(seriesId)

                viewModel.seriesEpisode.observe(this, { seriesWithEpisodeResource ->
                    if (seriesWithEpisodeResource != null) {
                        when (seriesWithEpisodeResource.status) {
                            Status.LOADING -> activityDetailSeriesBinding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> if (seriesWithEpisodeResource.data != null) {
                                activityDetailSeriesBinding?.progressBar?.visibility = View.GONE
                                activityDetailSeriesBinding?.nestedScrollView?.visibility = View.VISIBLE
                                adapter.setEpisodes(seriesWithEpisodeResource.data.mEpisodes)
                                adapter.notifyDataSetChanged()
                                populateSeries(seriesWithEpisodeResource.data.mSeries)
                            }
                            Status.ERROR -> {
                                activityDetailSeriesBinding?.progressBar?.visibility = View.GONE
                                Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
        }

        with(detailContentBinding?.rvEpisodeSeries) {
            this?.isNestedScrollingEnabled = false
            this?.layoutManager = LinearLayoutManager(this@DetailSeriesActivity)
            this?.setHasFixedSize(true)
            this?.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this?.context, DividerItemDecoration.VERTICAL)
            this?.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.seriesEpisode.observe(this, { seriesWithEpisode ->
            if (seriesWithEpisode != null) {
                when (seriesWithEpisode.status) {
                    Status.LOADING -> activityDetailSeriesBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> if (seriesWithEpisode.data != null) {
                        activityDetailSeriesBinding?.progressBar?.visibility = View.GONE
                        val state = seriesWithEpisode.data.mSeries.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailSeriesBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
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
        _activityDetailSeriesBinding = null
        _detailContentBinding = null
    }

    private fun populateSeries(seriesEntity: MovieEntity) {
        detailContentBinding?.tvTitleSeries?.text = seriesEntity.title
        detailContentBinding?.tvGenresSeries?.text = seriesEntity.genres
        detailContentBinding?.tvRealeseSeries?.text = seriesEntity.realese
        detailContentBinding?.tvRatingSeries?.text = seriesEntity.rating.toString()
        detailContentBinding?.tvDescriptionSeries?.text = seriesEntity.description
        detailContentBinding?.imagePosterSeries?.let {
            Glide.with(this)
                .load(seriesEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(it)
        }

        detailContentBinding?.btnStartSeries?.setOnClickListener {
            val intent = Intent(this@DetailSeriesActivity, SeriesReaderActivity::class.java)
            intent.putExtra(SeriesReaderActivity.EXTRA_SERIES_ID, seriesEntity.id)
            startActivity(intent)
        }
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
        const val EXTRA_SERIES = "extra_series"
    }

}