package com.go.shopping

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class GGApplication :Application(){


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}