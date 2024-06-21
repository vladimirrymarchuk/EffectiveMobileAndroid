package com.example.effectivemobile.ui.airtikets

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.effectivemobile.databinding.FragmentAirTiketsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AirTickets : Fragment() {

    private val viewModel: AirTicketsViewModel by viewModel()

    private lateinit var binding: FragmentAirTiketsBinding

    private lateinit var offerAdapter: OfferAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAirTiketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.offers.collect {
                offerAdapter = OfferAdapter(it)
                init()
            }
        }
        binding.apply {
            if (viewModel.placeA != "") {
                searchField1.setText(viewModel.placeA)
            }
            searchField1.addTextChangedListener {
                viewModel.placeA = it.toString()
            }
            searchIcon.setOnClickListener {
                Toast.makeText(context, "Клик", Toast.LENGTH_SHORT).show()
            }
            searchField2.setOnClickListener {
                viewModel.savePlaceA()
                val bottomSheet = BottomSheetSearch(viewModel)
                bottomSheet.show(parentFragmentManager, "bottomSheetSearch")
            }
        }
    }

    private fun init() {
        binding.offersView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }
    }

    override fun onDestroy() {
        viewModel.savePlaceA()
        super.onDestroy()
    }
}