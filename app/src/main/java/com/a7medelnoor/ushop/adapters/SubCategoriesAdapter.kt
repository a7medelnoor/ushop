package com.a7medelnoor.ushop.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.data.model.response.CategoriesData
import com.bumptech.glide.Glide

class SubCategoriesAdapter(
    private val subCategoriesList: List<CategoriesData>,
    private val context: Context
) : RecyclerView.Adapter<SubCategoriesAdapter.SubCategoriesAdapter>() {
    lateinit var subCategoriesAdapter: com.a7medelnoor.ushop.adapters.SubCategoriesAdapter
    class SubCategoriesAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val subCategoriesTextTitle: TextView
        val subCategoriesImageView: ImageView
        val childSubCategoriesRecyclerView: RecyclerView

        init {
            subCategoriesImageView = itemView.findViewById(R.id.sub_all_categories_image_view)
            subCategoriesTextTitle = itemView.findViewById(R.id.sub_all_categories_title)
            childSubCategoriesRecyclerView = itemView.findViewById(R.id.child_sup_all_categories_recycler_view)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoriesAdapter {
        val inflateView = LayoutInflater.from(parent.context)
            .inflate(R.layout.sub_layout_design, parent, false)
        return SubCategoriesAdapter(inflateView)
    }

    override fun onBindViewHolder(holder: SubCategoriesAdapter, position: Int) {
        val subCategoriesList = subCategoriesList.get(position)
        holder.subCategoriesTextTitle.text = subCategoriesList.name
        Glide.with(holder.itemView)
            .load(subCategoriesList.image)
            .into(holder.subCategoriesImageView)
        holder.subCategoriesImageView.setOnClickListener {
            subCategoriesAdapter =
                com.a7medelnoor.ushop.adapters.SubCategoriesAdapter(listOf(subCategoriesList),context)
            holder.childSubCategoriesRecyclerView.adapter = subCategoriesAdapter
            val gridLayoutManager : GridLayoutManager = GridLayoutManager(context,3)
            holder.childSubCategoriesRecyclerView.layoutManager = gridLayoutManager
            holder.childSubCategoriesRecyclerView.adapter!!.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return subCategoriesList.size
    }
}