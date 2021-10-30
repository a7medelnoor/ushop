package com.a7medelnoor.ushop.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesData(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    @SerializedName("image")
    private val image: String,
    @SerializedName("subcategories")
    private val subcategories: List<CategoriesData>
)