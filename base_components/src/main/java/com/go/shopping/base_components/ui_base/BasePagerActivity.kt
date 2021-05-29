package com.go.shopping.base_components.ui_base

import androidx.viewpager.widget.ViewPager

abstract class BasePagerActivity : BaseActivity(), ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
    }
}