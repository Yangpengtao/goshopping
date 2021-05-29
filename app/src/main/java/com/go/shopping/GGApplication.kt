package com.go.shopping

import android.app.Application
import android.content.Context

class GGApplication :Application(){


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }
}