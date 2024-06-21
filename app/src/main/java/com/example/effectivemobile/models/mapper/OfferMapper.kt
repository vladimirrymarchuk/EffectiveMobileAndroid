package com.example.effectivemobile.models.mapper

import com.example.domain.models.Offer
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.models.OfferItem
import java.util.Locale


fun List<Offer>.asOfferItemList() = this.mapIndexed { index, offer ->
    OfferItem(
        imageId = Constant.IMAGES[index % 3],
        town = offer.town,
        price = "От ${
            String.format(Locale.US, "%,d", offer.price.value).replace(',', ' ')
        } ₽"
    )
}



