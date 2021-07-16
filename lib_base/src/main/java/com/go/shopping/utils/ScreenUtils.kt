package com.go.shopping.utils

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

    fun px2dp(context: Context, px: Int): Int {
        return (px / getScreen(context).density).toInt()
    }

    fun dp2px(context: Context, dp: Int): Int {
        return (dp * getScreen(context).density).toInt()
    }
}
