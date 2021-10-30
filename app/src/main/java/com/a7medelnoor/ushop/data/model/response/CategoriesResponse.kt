package com.a7medelnoor.ushop.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesResponse (
    @SerializedName("code")
    private val code: Int,
    @SerializedName("status")
    private val status: String,
    @SerializedName("data")
    private val data: List<CategoriesData>
        )
