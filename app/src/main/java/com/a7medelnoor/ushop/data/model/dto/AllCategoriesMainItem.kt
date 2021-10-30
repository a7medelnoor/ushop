package com.a7medelnoor.ushop.data.model.dto

import com.google.gson.annotations.SerializedName

data class AllCategoriesMainItem(
    @SerializedName("image")
    private val image: Int,
    @SerializedName("name")
    private val name: String
)