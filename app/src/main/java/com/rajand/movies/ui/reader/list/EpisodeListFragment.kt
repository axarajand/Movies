package com.rajand.movies.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.databinding.FragmentEpisodeListBinding
import com.rajand.movies.ui.reader.SeriesReaderActivity
import com.rajand.movies.ui.reader.SeriesReaderCallback
import com.rajand.movies.ui.reader.SeriesReaderViewModel
import com.rajand.movies.viewmodel.ViewModelFactory
import com.rajand.movies.vo.Status

class EpisodeListFragment : Fragment() {

    private lateinit var viewModel: SeriesReaderViewModel

    private var _fragmentEpisodeListBinding: FragmentEpisodeListBinding? = null
    private val fragmentEpisodeListBinding get() = _fragmentEpisodeListBinding

    private lateinit var adapter: EpisodeListAdapter
    private lateinit var seriesReaderCallback: SeriesReaderCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        // Inflate the layout for this fragment
        _fragmentEpisodeListBinding = FragmentEpisodeListBinding.inflate(inflater, container, false)
        return fragmentEpisodeListBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[SeriesReaderViewModel::class.java]
        adapter = EpisodeListAdapter(this)

        viewModel.episodes.observe(viewLifecycleOwner, { episodeEntities ->
            if (episodeEntities != null) {
                when (episodeEntities.status) {
                    Status.LOADING -> fragmentEpisodeListBinding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        fragmentEpisodeListBinding?.progressBar?.visibility = View.GONE
                        populateRecyclerView(episodeEntities.data as List<EpisodeEntity>)
                    }
                    Status.ERROR -> {
                        fragmentEpisodeListBinding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        seriesReaderCallback = context as SeriesReaderActivity
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentEpisodeListBinding = null
    }

    fun onItemClicked(position: Int, episodeId: Int) {
        seriesReaderCallback.moveTo(position, episodeId)
        viewModel.setSelectedEpisode(episodeId)
    }

    private fun populateRecyclerView(episodes: List<EpisodeEntity>) {
        with(fragmentEpisodeListBinding) {
            this?.progressBar?.visibility = View.GONE
            adapter.setEpisodes(episodes)
            this?.rvEpisode?.layoutManager = LinearLayoutManager(context)
            this?.rvEpisode?.setHasFixedSize(true)
            this?.rvEpisode?.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            this?.rvEpisode?.addItemDecoration(dividerItemDecoration)
        }
    }

    companion object {
        val TAG: String = EpisodeListFragment::class.java.simpleName
        fun newInstance(): EpisodeListFragment = EpisodeListFragment()
    }

}