package com.a7medelnoor.ushop

import android.app.Application
import com.a7medelnoor.ushop.util.AppSharedPreferences

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppSharedPreferences.init(this)
    }
}