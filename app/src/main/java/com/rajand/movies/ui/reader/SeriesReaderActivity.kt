package com.rajand.movies.ui.reader

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rajand.movies.R
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.ui.reader.content.EpisodeContentFragment
import com.rajand.movies.ui.reader.list.EpisodeListFragment
import com.rajand.movies.viewmodel.ViewModelFactory
import com.rajand.movies.vo.Resource
import com.rajand.movies.vo.Status

class SeriesReaderActivity : AppCompatActivity(), SeriesReaderCallback {

    private var isLarge = false
    private lateinit var viewModel: SeriesReaderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_series_reader)

        if (findViewById<View>(R.id.frame_list) != null) {
            isLarge = true
        }

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[SeriesReaderViewModel::class.java]

        val bundle = intent.extras
        if (bundle != null) {
            val seriesId = bundle.getInt(EXTRA_SERIES_ID)
            if (seriesId != 0) {
                viewModel.setSelectedSeries(seriesId)
                populateFragment()
            }
        }
    }

    override fun moveTo(position: Int, seriesId: Int) {
        if (!isLarge) {
            val fragment = EpisodeContentFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.frame_container, fragment, EpisodeContentFragment.TAG)
                .addToBackStack(null)
                .commit()
       }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (!isLarge) {
            var fragment = supportFragmentManager.findFragmentByTag(EpisodeListFragment.TAG)
            if (fragment == null) {
                fragment = EpisodeListFragment.newInstance()
                fragmentTransaction.add(R.id.frame_container, fragment, EpisodeListFragment.TAG)
                fragmentTransaction.addToBackStack(null)
            }
            fragmentTransaction.commit()
        } else {
            var fragmentList = supportFragmentManager.findFragmentByTag(EpisodeListFragment.TAG)
            if (fragmentList == null) {
                fragmentList = EpisodeListFragment.newInstance()
                fragmentTransaction.add(R.id.frame_list, fragmentList, EpisodeListFragment.TAG)
            }
            var fragmentContent = supportFragmentManager.findFragmentByTag(EpisodeContentFragment.TAG)
            if (fragmentContent == null) {
                fragmentContent = EpisodeContentFragment.newInstance()
                fragmentTransaction.add(R.id.frame_content, fragmentContent, EpisodeContentFragment.TAG)
            }
            fragmentTransaction.commit()
        }
    }

    private fun removeObserver() {
        viewModel.episodes.removeObserver(initObserver)
    }

    private fun getLastWatchFromEpisodes(episodeEntities: List<EpisodeEntity>): Int? {
        var lastWatchEpisode: Int? = null
        for (episodeEntity in episodeEntities) {
            if (episodeEntity.watch) {
                lastWatchEpisode = episodeEntity.episodeId
                continue
            }
            break
        }
        return lastWatchEpisode
    }

    private val initObserver: Observer<Resource<List<EpisodeEntity>>> = Observer{ episodes ->
        if (episodes != null) {
            when (episodes.status) {
                Status.LOADING -> {
                }
                Status.SUCCESS -> {
                    val dataEpisodes: List<EpisodeEntity>? = episodes.data
                    if (dataEpisodes != null && dataEpisodes.isNotEmpty()) {
                        val firstEpisode = dataEpisodes[0]
                        val isFirstEpisodeWatch = firstEpisode.watch
                        if (!isFirstEpisodeWatch) {
                            val firstEpisodeId = firstEpisode.episodeId
                            viewModel.setSelectedEpisode(firstEpisodeId)
                        } else {
                            val lastWatchEpisodeId = getLastWatchFromEpisodes(dataEpisodes)
                            if (lastWatchEpisodeId != null) {
                                viewModel.setSelectedEpisode(lastWatchEpisodeId)
                            }
                        }
                    }
                    removeObserver()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Gagal menampilkan data.", Toast.LENGTH_SHORT).show()
                    removeObserver()
                }
            }
        }
    }

    companion object {
        const val EXTRA_SERIES_ID = "extra_series_id"
    }

}