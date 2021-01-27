package com.example.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.game.data.entity.Top
import kotlinx.android.synthetic.main.main_item.view.*

class MainAdapter() : ListAdapter<Top, MainAdapter.GameViewHolder>(DiffCallBack()) {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Top) = with(itemView) {
            name.text = item.game.name
            channels.text = context.getString(R.string.channel) + item.channels.toString()
            viewers.text = context.getString(R.string.viewer) + item.viewers.toString()
            Glide.with(context)
                .load(item.game.box.large)
                .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}


class DiffCallBack : DiffUtil.ItemCallback<Top>() {
    override fun areItemsTheSame(oldItem: Top, newItem: Top): Boolean {
        return oldItem.game.id == newItem.game.id
    }

    override fun areContentsTheSame(oldItem: Top, newItem: Top): Boolean {
        return oldItem == newItem
    }

}