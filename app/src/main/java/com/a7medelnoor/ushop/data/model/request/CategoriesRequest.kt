package com.a7medelnoor.ushop.data.model.request

import com.google.gson.annotations.SerializedName

data class CategoriesRequest(
    @SerializedName("server_key")
    private val server_key: String,
    @SerializedName("access_token")
    private val access_token: String,
)