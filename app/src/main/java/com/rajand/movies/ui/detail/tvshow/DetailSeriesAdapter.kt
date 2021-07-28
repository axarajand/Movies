package com.rajand.movies.ui.detail.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.databinding.ItemsEpisodeListBinding

class DetailSeriesAdapter : RecyclerView.Adapter<DetailSeriesAdapter.EpisodeViewHolder>() {

    private val listEpisode = ArrayList<EpisodeEntity>()

    fun setEpisodes(episodes: List<EpisodeEntity>?) {
        if (episodes == null) return
        this.listEpisode.clear()
        this.listEpisode.addAll(episodes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemEpisodeListBinding = ItemsEpisodeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(itemEpisodeListBinding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = listEpisode[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int = listEpisode.size

    inner class EpisodeViewHolder(private val binding: ItemsEpisodeListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeEntity) {
            with(binding) {
                tvEpisodeTitle.text = episode.title
                tvEpisodeRealese.text = episode.realese
            }
        }
    }

}