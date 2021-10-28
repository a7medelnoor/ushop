package com.a7medelnoor.ushop.data.model.response

data class LoginResponse (
    val code: Int,
    val status: String,
    val dataResponse: UserDataResponse
        )