package com.rajand.movies.ui.reader.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rajand.movies.R
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.databinding.FragmentEpisodeContentBinding
import com.rajand.movies.ui.reader.SeriesReaderViewModel
import com.rajand.movies.viewmodel.ViewModelFactory

class EpisodeContentFragment : Fragment() {

    private var _fragmentEpisodeContentBinding: FragmentEpisodeContentBinding? = null
    private val fragmentEpisodeContentBinding get() = _fragmentEpisodeContentBinding

    private lateinit var viewModel: SeriesReaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        // Inflate the layout for this fragment
        _fragmentEpisodeContentBinding = FragmentEpisodeContentBinding.inflate(inflater, container, false)
        return fragmentEpisodeContentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(requireActivity(), factory)[SeriesReaderViewModel::class.java]

            fragmentEpisodeContentBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.selectedEpisode.observe(viewLifecycleOwner, { episode ->
                fragmentEpisodeContentBinding?.progressBar?.visibility = View.GONE
                if (episode != null) {
                    populateWebView(episode)
                }
                setButtonNextPrevState(episode)
                if (!episode.watch) {
                    viewModel.watchEpisode(episode)
                }
                fragmentEpisodeContentBinding?.btnNext?.setOnClickListener { viewModel.setNextPage() }
                fragmentEpisodeContentBinding?.btnPrev?.setOnClickListener { viewModel.setPrevPage() }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentEpisodeContentBinding = null
    }

    private fun populateWebView(episode: EpisodeEntity) {
        fragmentEpisodeContentBinding?.webView?.loadData("""
            <h1 align="center" styler="text-size: 18px;">${episode.title}</h1>
            <p><b>${getString(R.string.episode)} : </b>${episode.episodeNumber}</p>
            <p><b>${getString(R.string.realese)}</b> ${episode.realese}</p>
            <p><b>${getString(R.string.rating)}</b> ${episode.rating}</p>
            <p></p>
            <p>${episode.description}</p>
        """.trimIndent(), "text/html", "UTF-8")
    }

    private fun setButtonNextPrevState(episode: EpisodeEntity) {
        if (activity != null) {
            when (episode.episodeNumber) {
                1 -> {
                    fragmentEpisodeContentBinding?.btnPrev?.isEnabled = false
                    fragmentEpisodeContentBinding?.btnNext?.isEnabled = true
                }
                viewModel.getEpisodeSize() -> {
                    fragmentEpisodeContentBinding?.btnPrev?.isEnabled = true
                    fragmentEpisodeContentBinding?.btnNext?.isEnabled = false
                }
                else -> {
                    fragmentEpisodeContentBinding?.btnPrev?.isEnabled = true
                    fragmentEpisodeContentBinding?.btnNext?.isEnabled = true
                }
            }
        }
    }

    companion object {
        val TAG: String = EpisodeContentFragment::class.java.simpleName
        fun newInstance(): EpisodeContentFragment = EpisodeContentFragment()
    }

}