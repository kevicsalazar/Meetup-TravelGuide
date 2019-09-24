package com.kevicsalazar.uplabs.travelguide.features.home.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.kevicsalazar.uplabs.travelguide.R
import com.kevicsalazar.uplabs.travelguide.domain.entities.Spot
import com.kevicsalazar.uplabs.travelguide.utils.inflate
import kotlinx.android.synthetic.main.item_spot.view.*

class SpotAdapter(private val spots: List<Spot>) : RecyclerView.Adapter<SpotAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_spot)
        return ViewHolder(view)
    }

    override fun getItemCount() = spots.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.bind(spot)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(spot: Spot) = with(itemView) {
            tvTitle?.text = spot.name
            ivPicture?.load(spot.imageUrl)
        }
    }

}