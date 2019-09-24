package com.kevicsalazar.uplabs.travelguide.features.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.kevicsalazar.uplabs.travelguide.R
import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot
import com.kevicsalazar.uplabs.travelguide.features.base.BaseFragment
import com.kevicsalazar.uplabs.travelguide.features.home.adapters.CategoryAdapter
import com.kevicsalazar.uplabs.travelguide.features.home.adapters.SpotAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val viewModel by viewModel<HomeViewModel>()

    override fun getLayout() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(this, viewObserver)
        viewModel.getCategories()
        viewModel.getSpots()
    }

    private val viewObserver = Observer<HomeViewState> {
        when (it) {
            is HomeViewState.ShowCategories -> showCategories(it.categories)
            is HomeViewState.ShowPopularSpots -> showPopularSpots(it.spots)
            is HomeViewState.ShowCulturalSpots -> showCulturalSpots(it.spots)
        }
    }

    private fun showCategories(categories: List<Category>) {
        rvCategories?.apply {
            setHasFixedSize(true)
            adapter = CategoryAdapter(categories)
        }
    }

    private fun showPopularSpots(spots: List<Spot>) {
        rvPopularSpots?.apply {
            setHasFixedSize(true)
            adapter = SpotAdapter(spots)
        }
    }

    private fun showCulturalSpots(spots: List<Spot>) {
        rvCulturalSpots?.apply {
            setHasFixedSize(true)
            adapter = SpotAdapter(spots)
        }
    }

}