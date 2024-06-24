package com.example.effectivemobile.ui.airtikets.allTickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.effectivemobile.R
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.databinding.FragmentAllTicketsBinding
import com.example.effectivemobile.ui.airtikets.search.TicketAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllTicketsFragment : Fragment() {

    private val viewModel: AllTicketsViewModel by viewModel()

    private lateinit var binding: FragmentAllTicketsBinding

    private lateinit var ticketAdapter: TicketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            route.text = arguments?.getString("route") ?: ""
            info.text = arguments?.getString("info") ?: ""
            backBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_allTickets_to_searchFragment)
            }
            lifecycleScope.launch {
                viewModel.tickets.collect { tickets ->
                    val item = tickets.find { item ->
                        item.comfortable
                    }
                    if (item != null){
                        price.text = item.price
                        time.text = item.time
                        airportDeparture.text = item.airports[0]
                        airportArrival.text = item.airports[1]
                        ticketInfo.text = ""
                    }
                    val items = tickets.filter {
                        !it.comfortable
                    }
                    ticketAdapter = TicketAdapter(items)
                    init()
                }
            }
        }
    }

    private fun init() {
        binding.tickets.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ticketAdapter
        }
    }
}
