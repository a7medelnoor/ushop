package com.a7medelnoor.ushop.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesResponse (
    @SerializedName("code")
     val code: Int,
    @SerializedName("status")
     val status: String,
    @SerializedName("data")
     val data: List<CategoriesData>
        )
