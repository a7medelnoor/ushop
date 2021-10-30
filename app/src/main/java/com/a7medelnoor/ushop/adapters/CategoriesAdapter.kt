package com.a7medelnoor.ushop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.CategoriesAdapter.CategoriesAdapterViewHolder
import com.a7medelnoor.ushop.data.model.dto.AllCategoriesMainItem
import com.a7medelnoor.ushop.ui.allCategories.AllCategoriesFragment
import com.bumptech.glide.Glide

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapterViewHolder>() {
    private lateinit var mCategoriesList: ArrayList<AllCategoriesMainItem>

    class CategoriesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCategoriesMain =
            itemView.findViewById<ImageView>(R.id.all_categories_image_view)
        var textViewCategoriesMain = itemView.findViewById<TextView>(R.id.all_categories_title)
    }
    fun renewItemList(categoriesList: ArrayList<AllCategoriesMainItem>) {
        mCategoriesList = categoriesList
        notifyDataSetChanged()
    }
    fun addItemList(categoriesList: AllCategoriesMainItem) {
        mCategoriesList.add(categoriesList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapterViewHolder {
       val inflate = LayoutInflater.from(parent.context).inflate(R.layout.all_categories_main_layout, parent, false)
        return CategoriesAdapterViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: CategoriesAdapterViewHolder, position: Int) {

        holder.textViewCategoriesMain.text = mCategoriesList[position].toString()
        Glide.with(holder.itemView)
            .load(mCategoriesList[position])
            .into(holder.imageViewCategoriesMain)
    }

    override fun getItemCount(): Int {
        return mCategoriesList.size
    }
}