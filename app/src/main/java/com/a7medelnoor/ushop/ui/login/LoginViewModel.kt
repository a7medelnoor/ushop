package com.a7medelnoor.ushop.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a7medelnoor.ushop.data.model.request.LoginRequest
import com.a7medelnoor.ushop.data.model.response.LoginResponse
import com.a7medelnoor.ushop.data.network.ApiClient
import com.a7medelnoor.ushop.util.LoginSessionManager
import retrofit2.Call
import retrofit2.Response

class LoginViewModel : ViewModel() {
    lateinit var apiClient: ApiClient
    lateinit var loginSession: LoginSessionManager

    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var userData = MutableLiveData<LoginRequest>()
    fun getUser(): MutableLiveData<LoginRequest> {
        if (userData == null) {
            userData = MutableLiveData()
        }
        return userData
    }

    fun userLogin(serverKey: String, userName: String, password: String) {
        apiClient = ApiClient()
        apiClient.getApiService().userLogin(serverKey, userName, password)
            .enqueue(object : retrofit2.Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()
                    if (loginResponse?.code == 200 && loginResponse.data != null) {
                        loginSession.saveAuthToken(response.body()!!.data.access_token)
                        ("Succcessssssssssss")
                    } else {
                        ("email or password incorrect")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    ("Error please try again later")
                }

            })

    }

}
