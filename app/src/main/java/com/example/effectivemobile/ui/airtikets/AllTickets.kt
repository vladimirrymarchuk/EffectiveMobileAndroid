package com.example.effectivemobile.ui.airtikets

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.effectivemobile.R
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.databinding.FragmentAllTicketsBinding

class AllTickets : Fragment() {

    private val viewModel: AllTicketsViewModel by viewModels()

    private lateinit var binding: FragmentAllTicketsBinding

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
            info.text  = arguments?.getString("info") ?: ""
            backBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_allTickets_to_searchFragment)
            }
        }
    }
}