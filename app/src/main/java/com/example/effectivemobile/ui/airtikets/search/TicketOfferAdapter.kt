package com.example.effectivemobile.ui.airtikets.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.TicketOfferItemBinding
import com.example.effectivemobile.models.TicketOfferItem

class TicketOfferAdapter(private val ticketOfferList: List<TicketOfferItem>): RecyclerView.Adapter<TicketOfferAdapter.TicketOfferHolder>() {



    class TicketOfferHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = TicketOfferItemBinding.bind(itemView)
        fun bind(ticketOfferItem: TicketOfferItem) = with(binding) {
            icon.setImageResource(ticketOfferItem.colorId)
            title.text = ticketOfferItem.title
            price.text = ticketOfferItem.price
            timeRange.text = ticketOfferItem.timeRange
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketOfferHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_offer_item, parent, false)
        return TicketOfferHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: TicketOfferHolder, position: Int) {
        holder.bind(ticketOfferItem = ticketOfferList[position])
    }

}