package com.example.effectivemobile.models.mapper

import com.example.domain.models.TicketOffer
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.models.TicketOfferItem
import java.util.Locale

fun List<TicketOffer>.asTicketOfferItemList() = this.mapIndexed { index, ticketOffer ->
    TicketOfferItem(
        colorId = Constant.INDICATOR_COLORS[index % 3],
        title = ticketOffer.title,
        price  = "${
            String.format(Locale.US, "%,d", ticketOffer.price.value).replace(',', ' ')
        } ₽ ",
        timeRange = ticketOffer.timeRange.joinToString(" ")
    )
}
