package com.a7medelnoor.ushop.data.network

import com.a7medelnoor.ushop.util.AppConstants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var uShopApiService: UShopApiService

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    fun getApiService(): UShopApiService {
        // initialized api service if not initialized yet
        if (!::uShopApiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)

                .addConverterFactory(GsonConverterFactory.create())
                .build()

            uShopApiService = retrofit.create(UShopApiService::class.java)
        }

        return uShopApiService
    }
}