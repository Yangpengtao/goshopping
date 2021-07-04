package com.go.shopping.utils

import android.util.Log
import com.go.lib_base1.BuildConfig

/**
 * 日志输出类，统一管理日志输出
 */
object LogPrinter {

    private const val OUTPUT_LOG = true


    /**
     * @param msg 日志
     */
    fun info(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(Tag, msg)
        }
    }


    /**
     * @param msg 日志
     */
    fun debug(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(Tag, msg)
        }
    }


    /**
     * @param msg 日志
     */
    fun error(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(Tag, msg)
        }
    }

    /**
     * @param msg 日志
     */
    fun warning(Tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.w(Tag, msg)
        }
    }

}
