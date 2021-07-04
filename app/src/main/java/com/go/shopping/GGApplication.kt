package com.go.shopping

import android.content.Context
import com.go.lib_base1.network.okhttp.OKHttpProcessor
import com.go.lib_base1.shared_preference.SharedPreferenceProcessor
import com.go.shopping.base_components.proxy.HelperHttp
import com.go.shopping.base_components.proxy.HelperImageLoader
import com.go.shopping.base_components.proxy.HelperSharedPreference
import com.go.shopping.lib_base.image.GlideProcessor

class GGApplication : BaseApplication() {


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()

        ///不应该在这里注册
        HelperHttp.init(OKHttpProcessor(this))
        HelperSharedPreference.init(SharedPreferenceProcessor(this))
        HelperImageLoader.init(GlideProcessor)
    }
}