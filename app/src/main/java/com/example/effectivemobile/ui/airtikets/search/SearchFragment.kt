package com.example.effectivemobile.ui.airtikets.search

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.FragmentSearchBinding
import com.example.effectivemobile.ui.airtikets.allTickets.TicketOfferAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val viewModel: SearchViewModel by viewModel()

    private lateinit var tiketOfferAdapter: TicketOfferAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.ticketsOffers.collect { list ->
                if (list.isNotEmpty()) {
                    tiketOfferAdapter = TicketOfferAdapter(list)
                    init()
                }
            }
        }
        binding.apply {
            backBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_searchFragment_to_navigation_air_tikets)
            }
            searchField1.setText(arguments?.getString("placeA") ?: "")
            searchField2.setText(arguments?.getString("placeB") ?: "")
            viewModel.placeA = searchField1.text.toString()
            viewModel.placeB = searchField2.text.toString()
            searchField1.addTextChangedListener { place ->
                viewModel.placeA = place.toString()
            }
            searchField2.addTextChangedListener { place ->
                viewModel.placeB = place.toString()
            }
            deleteBtn.setOnClickListener {
                searchField2.setText("")
            }
            calendar.setOnClickListener {
                // Отобразить календарь или вызвать диалог выбора даты
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

                context?.let { it1 ->
                    DatePickerDialog(
                        it1,
                        { _, _, month, dayOfMonth ->
                            val selectedDate =
                                "$dayOfMonth ${Constant.MONTHS[month]}, ${Constant.DAYS[dayOfWeek % 7 ]}"
                            caledarText.text = selectedDate
                        },
                        year,
                        month,
                        dayOfWeek
                    )
                }?.show()
            }
            val calendar = Calendar.getInstance()
            val month = calendar.get(Calendar.MONTH)
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            caledarText.text = "$dayOfMonth ${Constant.MONTHS[month]}, ${Constant.DAYS[dayOfWeek % 7]}"
            allTicketsBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("route", "${viewModel.placeA} - ${viewModel.placeB}")
                bundle.putString("info", "${caledarText.text}, 1 пассажир")
                Log.i("placeA", viewModel.placeA)
                Log.i("placeB", viewModel.placeB)
                Constant.MAIN.navController.navigate(R.id.action_searchFragment_to_allTickets, bundle)
            }
        }
    }

    private fun init() {
        binding.ticketsOffers.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = tiketOfferAdapter
        }
    }
}