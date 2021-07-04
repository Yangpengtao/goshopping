package com.go.shopping

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.go.lib_base1.network.okhttp.OKHttpProcessor
import com.go.lib_base1.shared_preference.SharedPreferenceProcessor

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

    }
}