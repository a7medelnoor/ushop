package com.a7medelnoor.ushop.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.CategoriesAdapter.CategoriesAdapterViewHolder
import com.a7medelnoor.ushop.data.model.response.CategoriesData
import com.bumptech.glide.Glide

class CategoriesAdapter(
    private var mCategoriesList: List<CategoriesData>,
    private val context: Context,
//    private var subCategoriesAdapter: SubCategoriesAdapter
) :
    RecyclerView.Adapter<CategoriesAdapterViewHolder>() {
    private val TAG = "CategoriesAdapter"
    private val viewPool = RecyclerView.RecycledViewPool()
    private lateinit var subCategoriesAdapter: SubCategoriesAdapter
    private lateinit var layoutManager: LinearLayoutManager


    class CategoriesAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewCategoriesMain: ImageView
        val textViewCategoriesMain: TextView
        val childRecyclerView: RecyclerView

        init {
            imageViewCategoriesMain =
                itemView.findViewById<ImageView>(R.id.all_categories_image_view)
            textViewCategoriesMain =
                itemView.findViewById<TextView>(R.id.all_categories_title)
            childRecyclerView =
                itemView.findViewById<RecyclerView>(R.id.sup_all_categories_recycler_view)
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
        val childLayoutManager = LinearLayoutManager(
            holder.childRecyclerView.context, LinearLayoutManager.HORIZONTAL, false
        )
        childLayoutManager.initialPrefetchItemCount=3
        holder.imageViewCategoriesMain.setOnClickListener {
            subCategoriesAdapter = SubCategoriesAdapter(lists.subcategories,context)
            holder.childRecyclerView.adapter = subCategoriesAdapter
            holder.childRecyclerView.layoutManager = childLayoutManager
            holder.childRecyclerView.adapter!!.notifyDataSetChanged()
//            adapter = SubCategoriesAdapter(lists.subcategories)
//            setRecycledViewPool(viewPool)
        }
//        holder.imageViewCategoriesMain.setOnClickListener {
//            subCategoriesAdapter = SubCategoriesAdapter(mCategoriesList,context)
//            holder.childRecyclerView.adapter = subCategoriesAdapter
//            Log.d(TAG, "SUBBBBBBBBBB" + subCategoriesAdapter)
//            val gridLayoutManager : GridLayoutManager = GridLayoutManager(context,3)
////            val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
////            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
//            holder.childRecyclerView.layoutManager = gridLayoutManager
//            holder.childRecyclerView.adapter!!.notifyDataSetChanged()
//        }
    }

    override fun getItemCount(): Int {
        return mCategoriesList.size
    }
}