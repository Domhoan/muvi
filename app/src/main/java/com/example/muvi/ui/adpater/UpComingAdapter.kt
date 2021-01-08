package com.example.muvi.ui.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.muvi.base.BaseAdapter
import com.example.muvi.base.BaseViewHolder
import com.example.muvi.data.model.Movie
import com.example.muvi.databinding.ItemUpcomingBinding

class UpComingAdapter (
    private val listener: (Movie) -> Unit,
    loadMore: () -> Unit
) :
    BaseAdapter<Movie, ItemUpcomingBinding>(listener, loadMore) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Movie, ItemUpcomingBinding> {
        val itemView = ItemUpcomingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UpcomingHolder(itemView, listener)
    }

    class UpcomingHolder(
        private val itemMoviePosterBinding: ItemUpcomingBinding,
        listener: (Movie) -> Unit
    ) : BaseViewHolder<Movie, ItemUpcomingBinding>(itemMoviePosterBinding, listener) {
        override fun onBind(itemData: Movie) {
            super.onBind(itemData)
            itemMoviePosterBinding.movie = itemData
        }
    }
}
