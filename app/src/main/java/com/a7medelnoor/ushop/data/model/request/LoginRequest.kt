package com.a7medelnoor.ushop.data.model.request

data class LoginRequest(
    val server_key: String,
    val username: String,
    val password: String
)