package com.rajand.movies.ui.reader.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajand.movies.data.source.local.entity.EpisodeEntity
import com.rajand.movies.databinding.ItemsEpisodeListCustomBinding

class EpisodeListAdapter internal constructor(private val listener: EpisodeListFragment) : RecyclerView.Adapter<EpisodeListAdapter.EpisodeViewHolder>() {
    private val listEpisodes = ArrayList<EpisodeEntity>()

    internal fun setEpisodes(episodes: List<EpisodeEntity>?) {
        if (episodes == null) return
        this.listEpisodes.clear()
        this.listEpisodes.addAll(episodes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = ItemsEpisodeListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: EpisodeViewHolder, position: Int) {
        val episode = listEpisodes[position]
        viewHolder.bind(episode)
        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(viewHolder.adapterPosition, listEpisodes[viewHolder.adapterPosition].episodeId)
        }
    }

    override fun getItemCount(): Int = listEpisodes.size

    inner class EpisodeViewHolder(private val binding: ItemsEpisodeListCustomBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(episode: EpisodeEntity) {
            binding.tvEpisodeNumberCustom.text = "${episode.episodeNumber}."
            binding.tvEpisodeTitleCustom.text = episode.title
            binding.tvEpisodeRealeseCustom.text = episode.realese
        }
    }
}