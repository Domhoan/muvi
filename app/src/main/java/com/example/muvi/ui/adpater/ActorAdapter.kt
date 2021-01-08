package com.example.muvi.ui.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.muvi.base.BaseAdapter
import com.example.muvi.base.BaseViewHolder
import com.example.muvi.data.model.Actor
import com.example.muvi.databinding.ItemActorBinding

class ActorAdapter : BaseAdapter<Actor, ItemActorBinding>({}, {}) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<Actor, ItemActorBinding> =
        ActorHolder(
            ItemActorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    class ActorHolder(
        private val itemActorBinding: ItemActorBinding
    ) : BaseViewHolder<Actor, ItemActorBinding>(itemActorBinding, {}) {
        override fun onBind(itemData: Actor) {
            super.onBind(itemData)
            itemActorBinding.actor = itemData
        }
    }
}
