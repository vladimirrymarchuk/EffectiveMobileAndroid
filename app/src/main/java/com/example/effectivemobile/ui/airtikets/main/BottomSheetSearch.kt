package com.example.effectivemobile.ui.airtikets.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.effectivemobile.constant.Constant
import com.example.effectivemobile.R
import com.example.effectivemobile.databinding.BottomSheetFragmetSearchBinding
import com.example.effectivemobile.ui.airtikets.search.SearchFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetSearch(private val viewModel: AirTicketsViewModel) : BottomSheetDialogFragment() {

    private val binding by lazy { BottomSheetFragmetSearchBinding.inflate(layoutInflater) }

    override fun getTheme(): Int {
        return R.style.BottomSheetTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog = dialog as BottomSheetDialog
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        binding.apply {
            dismissBtn.setOnClickListener {
                dismiss()
            }
            searchField1.setText(viewModel.placeA)
            searchField1.addTextChangedListener { place ->
                viewModel.placeA = place.toString()
            }
            delete.setOnClickListener {
                searchField2.setText("")
            }
            anyWhereBtn.setOnClickListener() {
                searchField2.setText(R.string.anywhere)
            }
            searchBtn.setOnClickListener {
                if (viewModel.placeA != "" && searchField2.text.toString() != "") {
                    val searchFragment = SearchFragment()
                    val bundle = Bundle()
                    bundle.putString("placeA", viewModel.placeA)
                    bundle.putString("placeB", searchField2.text.toString())
                    searchFragment.arguments = bundle
                    Constant.MAIN.navController.navigate(R.id.action_navigation_air_tikets_to_searchFragment, bundle)
                    dismiss()
                }
            }
            difficultRouteBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_navigation_air_tikets_to_dificultRouteFragment3)
                dismiss()
            }
            hotWeekendBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_navigation_air_tikets_to_hotTicketFragment3)
                dismiss()
            }
            weekendBtn.setOnClickListener {
                Constant.MAIN.navController.navigate(R.id.action_navigation_air_tikets_to_weekendFragment3)
                dismiss()
            }
        }
    }
}