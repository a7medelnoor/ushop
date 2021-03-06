package com.a7medelnoor.ushop.util

import android.content.Context
import android.content.SharedPreferences

object AppSharedPreferences {
  private const val NAME = "UserLogin"
  private const val MODE = Context.MODE_PRIVATE
  private lateinit var preferences: SharedPreferences
 
  //SharedPreferences variables
  private val IS_LOGIN = Pair("is_login", false)
  private val USERNAME = Pair("email", "")
  private val PASSWORD = Pair("password", "")
 
  fun init(context: Context) {
    preferences = context.getSharedPreferences(NAME, MODE)
  }
 
  //an inline function to put variable and save it
  private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
  }
 
  //SharedPreferences variables getters/setters
  var isLogin: Boolean
    get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
    set(value) = preferences.edit {
      it.putBoolean(IS_LOGIN.first, value)
    }
 
  var username: String
    get() = preferences.getString(USERNAME.first, USERNAME.second) ?: ""
    set(value) = preferences.edit {
      it.putString(USERNAME.first, value)
    }
 
  var password: String
    get() = preferences.getString(PASSWORD.first, PASSWORD.second) ?: ""
    set(value) = preferences.edit {
      it.putString(PASSWORD.first, value)
    }
}