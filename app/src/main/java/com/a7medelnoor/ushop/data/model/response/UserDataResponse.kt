package com.a7medelnoor.ushop.data.model.response

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("user_id")
    val user_id: Int,
    @SerializedName("access_token")
    val access_token: String
)