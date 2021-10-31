package com.a7medelnoor.ushop.ui.allCategories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.adapters.CategoriesAdapter
import com.a7medelnoor.ushop.adapters.SubCategoriesAdapter
import com.a7medelnoor.ushop.data.model.response.CategoriesData
import com.a7medelnoor.ushop.data.model.response.CategoriesResponse
import com.a7medelnoor.ushop.data.network.ApiClient
import com.a7medelnoor.ushop.util.AppConstants.Companion.SERVER_KEY
import com.a7medelnoor.ushop.util.LoginSessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllCategoriesFragment : Fragment() {
    private val TAG = "AllCategoriesFragment"
    private lateinit var adapter: CategoriesAdapter
    private lateinit var subAdapter :SubCategoriesAdapter
    var mCategoriesList = ArrayList<CategoriesData>()
    var subCategoriesList = ArrayList<CategoriesData>()
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var apiClient: ApiClient
    private lateinit var loginSessionManager: LoginSessionManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_categories, container, false)
        mRecyclerView = view.findViewById<RecyclerView>(R.id.all_categories_recycler_view)
        subAdapter = SubCategoriesAdapter(subCategoriesList)
        adapter = CategoriesAdapter(mCategoriesList,requireContext(),subAdapter )
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        getCategoriesData()
        return view
    }

    private fun getCategoriesData() {
        apiClient = ApiClient()
        loginSessionManager = LoginSessionManager(requireContext())
        val access_token = loginSessionManager.fetchAuthToken()
        apiClient.getApiService().getCategories(SERVER_KEY, access_token)
            .enqueue(object : Callback<CategoriesResponse> {
                override fun onResponse(
                    call: Call<CategoriesResponse>,
                    response: Response<CategoriesResponse>
                ) {
                    if (response.code() == 200) {
                        mCategoriesList.addAll(response.body()!!.data)
                        mRecyclerView.adapter!!.notifyDataSetChanged()

                    }
                }

                override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                    Log.d(TAG, "SSSSSSSSSSSSSSSSSSS fad" + t.message)
                }


            })
    }
}