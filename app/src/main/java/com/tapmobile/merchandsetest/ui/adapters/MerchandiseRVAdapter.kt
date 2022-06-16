package com.tapmobile.merchandsetest.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tapmobile.merchandsetest.databinding.ItemRvBinding
import com.tapmobile.merchandsetest.entities.Merchandise


class MerchandiseRVAdapter(var merchandiseList: List<Merchandise>) :
    RecyclerView.Adapter<MerchandiseRVAdapter.MerchandiseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MerchandiseViewHolder(
        ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun addItems(merchandiseList: List<Merchandise>) {
        this.merchandiseList = merchandiseList
        notifyDataSetChanged()
    }

    override fun getItemCount() = merchandiseList.size

    override fun onBindViewHolder(holder: MerchandiseViewHolder, position: Int) {
        holder.bind(merchandiseList[position])
    }

    inner class MerchandiseViewHolder(val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(merchandise: Merchandise) {
            with(binding) {
                itemRvName.text = merchandise.name
                itemRvPrice.text = merchandise.price
                merchandise.photos?.let {
                    it.first()?.let {
                        itemRvPhoto.load(it)
                    }
                }
            }
        }
    }

    fun ImageView.load(url: String?) =
        Glide.with(this)
            .load(url)
            .into(this)
}

