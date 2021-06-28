@file:Suppress("DEPRECATION")

package com.go.module_main

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by ypt on 2017/7/14.
 */
class MainPagerAdapter(fragmentActivity: FragmentActivity, fragments: Array<Fragment?>) :
    FragmentStateAdapter(fragmentActivity) {

    private val mFragments = fragments;

    override fun getItemCount(): Int {
        return mFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return mFragments[position]!!
    }

}

/*
* class MainPagerAdapter(fm: FragmentManager, private val mFragments: Array<Fragment?>) :
    FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]!!
    }


}*/
