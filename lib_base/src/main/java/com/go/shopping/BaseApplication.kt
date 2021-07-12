package com.go.shopping

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.go.shopping.lib_base.image.GlideProcessor
import com.go.shopping.lib_base.network.okhttp.OKHttpProcessor
import com.go.shopping.lib_base.shared_preference.SharedPreferenceProcessor
import com.go.shopping.proxy.HelperHttp
import com.go.shopping.proxy.HelperImageLoader
import com.go.shopping.proxy.HelperSharedPreference

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        HelperHttp.init(OKHttpProcessor(this))
        HelperSharedPreference.init(SharedPreferenceProcessor(this))
        HelperImageLoader.init(GlideProcessor)
    }
}