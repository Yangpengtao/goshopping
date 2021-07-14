package com.go.shopping

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.go.shopping.lib_base.image.GlideProcessor
import com.go.shopping.lib_base.network.okhttp.OKHttpProcessor
import com.go.shopping.lib_base.shared_preference.SharedPreferenceProcessor
import com.go.shopping.proxy.HelperHttp
import com.go.shopping.proxy.HelperImageLoader
import com.go.shopping.proxy.HelperSharedPreference
import com.go.shopping.proxy.HelperThreadPool
import com.go.shopping.utils.LogPrinter
import com.oomall.lib_security.CheckUtil

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
        HelperHttp.init(OKHttpProcessor(this))
        HelperImageLoader.init(GlideProcessor)
        HelperThreadPool.executeSingle(Runnable {
            HelperSharedPreference.init(
                SharedPreferenceProcessor(this)
            )
        })

        if (CheckUtil.isEmulator()) {
            LogPrinter.warning("BaseApplication", "----current display is emulator!");
        }
        if (CheckUtil.isDebuggable(this)) {
            LogPrinter.warning("BaseApplication", "----debuggable is open!");
        }
    }
}