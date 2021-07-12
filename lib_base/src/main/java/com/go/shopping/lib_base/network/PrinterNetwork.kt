package com.go.shopping.lib_base.network

import android.util.Log
import com.go.shopping.BuildConfig

/**
 * 日志输出类，统一管理日志输出
 */
object PrinterNetwork {

    /**
     * @param msg 日志
     */
    fun i(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(Tag, msg)
        }
    }


    /**
     * @param msg 日志
     */
    fun d(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(Tag, msg)
        }
    }


    /**
     * @param msg 日志
     */
    fun e(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(Tag, msg)
        }
    }

}
