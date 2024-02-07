package com.farydrop.onlinestoreapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.farydrop.onlinestoreapp.data.entity.Item

class CatalogDiffCallback: DiffUtil.ItemCallback<Item>( ) {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
