package com.a7medelnoor.ushop.data.network

import com.a7medelnoor.ushop.data.model.response.LoginResponse
import com.a7medelnoor.ushop.util.AppConstants.Companion.LOGIN_URL
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface UShopApiService {

    @POST(LOGIN_URL)
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun login(
        @Field("server_key") server_key: String,
        @Field("username") username: String,
        @Field("password") password: String
    ): retrofit2.Call<LoginResponse>
}