package com.example.effectivemobile.ui.airtikets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetOffersUseCase
import com.example.effectivemobile.R
import com.example.effectivemobile.models.Offer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AirTicketsViewModel(private val getOffersUseCase: GetOffersUseCase) : ViewModel() {
    private val _offers = MutableStateFlow<List<Offer>>(emptyList())
    val offers: StateFlow<List<Offer>> = _offers

    private val images = listOf(
        R.drawable.offer1,
        R.drawable.offer2,
        R.drawable.offer3
    )

    fun getOffers() {
        viewModelScope.launch(Dispatchers.IO) {
//            launch {
//                _offers.value = getOffersUseCase().mapIndexed { index, offer ->
//                    Offer(
//                        imageId = images[index % 3],
//                        town = offer.town,
//                        price = "От ${offer.price.value} ₽"
//                    )
//                }
//            }
            _offers.value = listOf(
                Offer(
                    imageId = R.drawable.offer1,
                    town = "Mосква",
                    price = "От 1000 ₽"
                ),
                Offer(
                    imageId = R.drawable.offer2,
                    town = "Mосква",
                    price = "От 1000 ₽"
                ),
                Offer(
                    imageId = R.drawable.offer3,
                    town = "Mосква",
                    price = "От 1000 ₽"
                )
            )
        }
    }
}