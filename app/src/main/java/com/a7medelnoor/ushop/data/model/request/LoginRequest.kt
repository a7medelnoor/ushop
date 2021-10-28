package com.a7medelnoor.ushop.data.model.request

data class LoginRequest(
    val username: String,
    val password: String,
    val server_key: String
)