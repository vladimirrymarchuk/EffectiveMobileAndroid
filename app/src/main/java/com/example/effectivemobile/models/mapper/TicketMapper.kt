package com.example.effectivemobile.models.mapper

import com.example.domain.models.Ticket
import com.example.effectivemobile.models.TicketItem
import kotlinx.coroutines.channels.ticker
import java.util.Locale

fun List<Ticket>.asTicketItemList(): List<TicketItem> = this.map { ticket ->
    ticket.asTicketItem()
}

fun Ticket.asTicketItem(): TicketItem = TicketItem(
    price = "${
        String.format(Locale.US, "%,d", this.price.value).replace(',', ' ')
    } ₽",
    time = "${
        this.departure.date.substring(
            this.departure.date.lastIndex - 4,
            this.departure.date.length
        )
    } - ${
        this.arrival.date.substring(
            this.arrival.date.lastIndex - 4,
            this.arrival.date.length
        )
    }",
    airports = listOf(
        this.departure.airport,
        this.arrival.airport
    ),
    info = "",
    comfortable = this.badge == "Самый удобный"
)

