package com.a7medelnoor.ushop.data.network

import android.telecom.Call
import com.a7medelnoor.ushop.data.model.request.LoginRequest
import com.a7medelnoor.ushop.data.model.response.LoginResponse
import com.a7medelnoor.ushop.util.AppConstants.Companion.LOGIN_URL
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UShopApiService {

    @POST(LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): retrofit2.Call<LoginResponse>
}