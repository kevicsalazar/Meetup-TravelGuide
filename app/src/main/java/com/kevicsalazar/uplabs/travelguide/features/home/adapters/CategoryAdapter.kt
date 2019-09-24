package com.kevicsalazar.uplabs.travelguide.features.home.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.kevicsalazar.uplabs.travelguide.R
import com.kevicsalazar.uplabs.travelguide.domain.entities.Category
import com.kevicsalazar.uplabs.travelguide.utils.inflate
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_category)
        return ViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(category: Category) = with(itemView) {
            tvTitle?.text = category.name
            ivPicture?.load(category.imageUrl)
        }
    }

}