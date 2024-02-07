package com.farydrop.onlinestoreapp.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Item

class CatalogDiffCallback: DiffUtil.ItemCallback<Catalog>( ) {
    override fun areItemsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Catalog, newItem: Catalog): Boolean {
        return oldItem == newItem
    }
}
