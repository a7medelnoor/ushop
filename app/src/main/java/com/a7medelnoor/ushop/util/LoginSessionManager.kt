package com.a7medelnoor.ushop.util

import android.content.Context
import android.content.SharedPreferences
import com.a7medelnoor.ushop.R
import com.a7medelnoor.ushop.util.AppConstants.Companion.USER_TOKEN

class LoginSessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    // save the auth token
    fun saveAuthToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    // fetch auth token
    fun fetchAuthToken(): String? {
        return sharedPreferences.getString(USER_TOKEN, null)
    }
}