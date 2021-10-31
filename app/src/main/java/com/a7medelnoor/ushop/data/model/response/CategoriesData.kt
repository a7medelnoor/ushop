package com.a7medelnoor.ushop.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesData(
    @SerializedName("id")
     val id: Int,
    @SerializedName("name")
     val name: String,
    @SerializedName("image")
     val image: String,
    @SerializedName("subcategories")
     val subcategories: List<CategoriesData>
)