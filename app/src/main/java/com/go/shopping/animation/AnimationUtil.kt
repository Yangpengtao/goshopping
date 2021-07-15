package com.go.shopping.animation

import android.animation.Animator
import android.view.View
import android.view.ViewAnimationUtils
import kotlin.math.hypot

object AnimationUtil {
    private const val duration = 1000L
    /**
     * offset[0] x偏移量
     * offset[1] y偏移量
     * 要么都传，要么都不传
     */
    fun startRevealAnim(view: View, hasListener: Boolean) {
        val centerX: Int = view.width / 2
        val centerY: Int = view.height / 2 + 100
        val endRadius = hypot(view.width.toDouble(), view.height.toDouble())
        val circularReveal = ViewAnimationUtils.createCircularReveal(
            view,
            centerX,
            centerY,
            0f,
            endRadius.toFloat()
        )
        circularReveal.duration = duration
        view.visibility = View.VISIBLE
        if (hasListener) {
            circularReveal.addListener(animationListener)
        }
        circularReveal.start()
    }

    private val animationListener = object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {

        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationStart(animation: Animator?) {
        }
    }



}