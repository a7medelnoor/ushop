package com.a7medelnoor.ushop.data.network

import com.a7medelnoor.ushop.util.AppConstants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var uShopApiService: UShopApiService


    fun getApiService(): UShopApiService {
        // initialized api service if not initialized yet
        if (uShopApiService != null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            uShopApiService = retrofit.create(UShopApiService::class.java)
        }

        return uShopApiService
    }
}