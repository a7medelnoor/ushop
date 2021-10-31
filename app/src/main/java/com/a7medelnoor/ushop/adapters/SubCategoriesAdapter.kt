package com.a7medelnoor.ushop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.data.model.response.CategoriesData
import com.bumptech.glide.Glide

class SubCategoriesAdapter(
    private val subCategoriesList: List<CategoriesData>,
) : RecyclerView.Adapter<SubCategoriesAdapter.SubCategoriesAdapter>() {
    class SubCategoriesAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subCategoriesTextTitle: TextView
        val subCategoriesImageView: ImageView

        init {
            subCategoriesImageView = itemView.findViewById(R.id.all_categories_image_view)
            subCategoriesTextTitle = itemView.findViewById(R.id.all_categories_title)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoriesAdapter {
        val inflateView = LayoutInflater.from(parent.context)
            .inflate(R.layout.all_categories_main_layout, parent, false)
        return SubCategoriesAdapter(inflateView)
    }

    override fun onBindViewHolder(holder: SubCategoriesAdapter, position: Int) {
        val subCategoriesList = subCategoriesList.get(position)
        holder.subCategoriesTextTitle.text = subCategoriesList.name
        Glide.with(holder.itemView)
            .load(subCategoriesList.name)
            .into(holder.subCategoriesImageView)
    }

    override fun getItemCount(): Int {
        return subCategoriesList.size
    }
}