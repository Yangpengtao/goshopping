package com.go.module_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter.getInstance
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.base_components.ui_base.BasePagerActivity
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouteTable.MAIN_ACTITIVTY)
class MainActivity : BasePagerActivity() {
    private var youLike: Fragment? = null
    private var userShow: Fragment? = null
    private var mygg: Fragment? = null
    private var home: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleColorTransparent(false)
        home = getInstance()
            .build(RouteTable.HOME_FRAGMENT)
            .navigation() as Fragment
        mygg = getInstance()
            .build(RouteTable.MY_GG_FRAGMENT)
            .navigation() as Fragment
        userShow = getInstance()
            .build(RouteTable.USER_SHOW_FRAGMENT)
            .navigation() as Fragment
        youLike = getInstance()
            .build(RouteTable.YOU_LIKE__FRAGMENT)
            .navigation() as Fragment
        val fragments = arrayOfNulls<Fragment>(4)
        fragments[0] = home
        fragments[1] = youLike
        fragments[2] = userShow
        fragments[3] = mygg

        val adapter = MainPagerAdapter(this, fragments)
        view_page.adapter = adapter
        view_page.offscreenPageLimit = 1
        view_page.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                nav_view.selectedItemId = nav_view.menu.getItem(position).itemId
            }
        })

        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_my_gg -> {
                    view_page.currentItem = 3
                }
                R.id.navigation_store -> {
                    view_page.currentItem = 0
                }
                R.id.navigation_user_show -> {
                    view_page.currentItem = 2
                }
                R.id.navigation_you_like -> {
                    view_page.currentItem = 1
                }
            }
            true
        }
    }

}
