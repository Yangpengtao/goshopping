@file:Suppress("DEPRECATION")
package com.go.module_main
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by ypt on 2017/7/14.
 */
class MainPagerAdapter(fm: FragmentManager, private val mFragments: Array<Fragment?>) :
    FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]!!
    }


}
