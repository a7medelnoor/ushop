package com.a7medelnoor.ushop

import android.app.Application
import com.a7medelnoor.ushop.util.AppPreferences

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)
    }
}