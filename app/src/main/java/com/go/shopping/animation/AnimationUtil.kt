package com.go.shopping.animation

import android.view.View
import android.view.ViewAnimationUtils
import com.go.shopping.utils.ScreenUtils
import kotlin.math.hypot

object AnimationUtil {

    private const val duration = 2000L

    /**
     * offset[0] x偏移量
     * offset[1] y偏移量
     * 要么都传，要么都不传
     */
    fun startRevealAnim(view: View ) {

        val centerX: Int = view.width / 2
        val centerY: Int = view.height / 2  //+ScreenUtils.dp2px(view.context,40)
        val endRadius = hypot(view.width.toDouble(), view.height.toDouble())
        val circularReveal = ViewAnimationUtils.createCircularReveal(
            view,
            centerX,
            centerY,
            0f,
            endRadius.toFloat()
        )
        circularReveal.duration = duration
        circularReveal.start()
    }



}