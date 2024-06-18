package com.example.effectivemobile.ui.airtikets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.OfferItemBinding
import com.example.effectivemobile.models.Offer

class OfferAdapter(private val offerList: List<Offer>) : RecyclerView.Adapter<OfferAdapter.OfferHolder>() {

    class OfferHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = OfferItemBinding.bind(itemView)

        fun bind(offer: Offer) = with(binding) {
            imageView.setImageResource(offer.imageId)
            town.text = offer.town
            price.text = offer.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferAdapter.OfferHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.offer_item, parent, false)
        return OfferHolder(view)
    }

    override fun onBindViewHolder(holder: OfferAdapter.OfferHolder, position: Int) {
        holder.bind(offer = offerList[position])
    }

    override fun getItemCount(): Int {
        return offerList.size
    }
}