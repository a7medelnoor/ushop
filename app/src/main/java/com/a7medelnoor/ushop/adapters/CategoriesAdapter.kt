package com.a7medelnoor.ushop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.CategoriesAdapter.CategoriesAdapterViewHolder
import com.a7medelnoor.ushop.data.model.response.CategoriesData
import com.bumptech.glide.Glide

class CategoriesAdapter(private var mCategoriesList: List<CategoriesData>) :
    RecyclerView.Adapter<CategoriesAdapterViewHolder>() {

    class CategoriesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCategoriesMain: ImageView
        val textViewCategoriesMain: TextView

        init {
            imageViewCategoriesMain =
                itemView.findViewById<ImageView>(R.id.all_categories_image_view)
            textViewCategoriesMain = itemView.findViewById<TextView>(R.id.all_categories_title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterViewHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.all_categories_main_layout, parent, false)
        return CategoriesAdapterViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CategoriesAdapterViewHolder, position: Int) {
        val lists = mCategoriesList.get(position)
        holder.textViewCategoriesMain.text = lists.name
        Glide.with(holder.itemView)
            .load(lists.image)
            .into(holder.imageViewCategoriesMain)
    }

    override fun getItemCount(): Int {
        return mCategoriesList.size
    }
}