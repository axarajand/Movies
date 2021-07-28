package com.rajand.movies.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rajand.movies.R
import com.rajand.movies.data.source.local.entity.MovieEntity
import com.rajand.movies.databinding.ItemsFavoriteBinding
import com.rajand.movies.ui.detail.movie.DetailMovieActivity
import com.rajand.movies.ui.detail.tvshow.DetailSeriesActivity

class FavoriteAdapter(private val callback: FavoriteFragment) : PagedListAdapter<MovieEntity, FavoriteAdapter.SeriesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SeriesViewHolder {
        val itemsFavoriteBinding = ItemsFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeriesViewHolder(itemsFavoriteBinding)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val series = getItem(position)
        if (series != null) {
            holder.bind(series)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    inner class SeriesViewHolder(private val binding: ItemsFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitleFavorite.text = movie.title
                tvItemCategoryFavorite.text = movie.category
                tvItemDescriptionFavorite.text = movie.description
                btnItemReadFavorite.setOnClickListener {
                    when(movie.category) {
                        "movie" -> {
                            val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.id)
                            itemView.context.startActivity(intent)
                        }
                        "series" -> {
                            val intent = Intent(itemView.context, DetailSeriesActivity::class.java)
                            intent.putExtra(DetailSeriesActivity.EXTRA_SERIES, movie.id)
                            itemView.context.startActivity(intent)
                        }
                    }
                }
                imgShareFavorite.setOnClickListener { callback.onShareClick(movie) }
                Glide.with(itemView.context)
                    .load(movie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(imgPosterFavorite)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}