package com.go.shopping.base_components.tools

import android.content.Context
import android.util.DisplayMetrics

/**
 * 获取屏幕相关信息
 */
object ScreenUtils {

    //获取屏幕高
    fun getScreenHeight(context: Context): Int {
        val dm = context.resources.displayMetrics
       return dm.heightPixels
    }

    //获取屏幕宽
    fun getScreenWidth(context: Context): Int {
        val dm = context.resources.displayMetrics
        return dm.widthPixels
    }

    /**
     * 获得屏幕对象
     *
     * @param context
     * @return
     */
    fun getScreen(context: Context): DisplayMetrics {
        return context.resources.displayMetrics
    }

}
