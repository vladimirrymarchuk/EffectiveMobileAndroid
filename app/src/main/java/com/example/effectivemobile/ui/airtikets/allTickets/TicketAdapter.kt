package com.example.effectivemobile.ui.airtikets.allTickets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.TicketItemBinding
import com.example.effectivemobile.models.TicketItem

class TicketAdapter(private val tickets: List<TicketItem>): RecyclerView.Adapter<TicketAdapter.TicketHolder>() {

    class TicketHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
        private val binding = TicketItemBinding.bind(viewItem)

        fun bind(ticket: TicketItem) = with(binding) {
            price.text = ticket.price
            time.text = ticket.time
            airportDeparture.text = ticket.airports[0]
            airportArrival.text = ticket.airports[1]
            ticketInfo.text = ticket.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_item, parent, false)
        return TicketHolder(view)
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        holder.bind(ticket = tickets[position])
    }
}