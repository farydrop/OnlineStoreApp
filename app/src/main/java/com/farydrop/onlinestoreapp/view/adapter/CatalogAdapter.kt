package com.farydrop.onlinestoreapp.view.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.databinding.CatalogItemBinding

class CatalogAdapter : ListAdapter<Catalog, CatalogAdapter.CatalogViewHolder>(CatalogDiffCallback()) {

    private var onClickListener: CatalogActionListener? = null

    interface CatalogActionListener {
        fun onCatalogFavorites(position: Int, catalog: Catalog)
        fun onCatalogDetails(position: Int, catalog: Catalog)
    }

    class CatalogViewHolder(private val binding: CatalogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val card = binding.cardView
        val img = binding.ivImage
        val heartNotPressed = binding.ivHeartNotPressed
        val heartPressed = binding.ivHeartPressed
        val priceWithoutDiscount = binding.tvPrice
        val priceWithDiscount = binding.tvPriceWithDiscount
        val discount = binding.tvDiscount
        val title = binding.tvTitle
        val subtitle = binding.tvDescription
        val rating = binding.tvRating
        val feedback = binding.tvFeedback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val view = CatalogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatalogViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val item = getItem(position)

        //todo add unit
        holder.img.setImageResource(item.imgOne)
        holder.title.text = item.title
        holder.subtitle.text = item.subtitle
        holder.priceWithoutDiscount.text = item.price.price
        holder.priceWithDiscount.text = item.price.priceWithDiscount
        holder.discount.text = "-${item.price.discount.toString()}%"
        holder.rating.text = item.feedback.rating.toString()
        holder.feedback.text = item.feedback.count.toString()

        holder.heartNotPressed.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onCatalogFavorites(position, item)
            }
        }

        holder.card.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onCatalogDetails(position, item)
            }
        }

        if (item.isFavorites){
            holder.heartPressed.visibility = View.VISIBLE
        } else {
            holder.heartPressed.visibility = View.GONE
        }

        holder.priceWithoutDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG



    }

    fun setOnClickListener(onClickListener: CatalogActionListener) {
        this.onClickListener = onClickListener
    }
}