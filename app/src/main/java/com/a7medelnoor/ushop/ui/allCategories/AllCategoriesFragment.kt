package com.a7medelnoor.ushop.ui.allCategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.CategoriesAdapter
import com.a7medelnoor.ushop.data.model.dto.AllCategoriesMainItem

class AllCategoriesFragment : Fragment() {
    private lateinit var adapter: CategoriesAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_categories, container, false)
        val mRecyclerView = view.findViewById<RecyclerView>(R.id.all_categories_recycler_view)
        adapter = CategoriesAdapter()
        linearLayoutManager = LinearLayoutManager(requireContext())
        mRecyclerView.layoutManager = linearLayoutManager
        val mCategoriesList = ArrayList<AllCategoriesMainItem>()
        mCategoriesList.add(AllCategoriesMainItem(R.drawable.ic_add, "Test"))
        adapter.renewItemList(mCategoriesList)
        mRecyclerView.adapter = adapter
        return view
    }
}