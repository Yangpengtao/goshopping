package com.go.module_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter.getInstance
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.base_components.ui_base.BasePagerActivity
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouteTable.MAIN_ACTITIVTY)
class MainActivity : BasePagerActivity() {
    var youLike: Fragment? = null
    var userShow: Fragment? = null
    var mygg: Fragment? = null
    var home: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleColorTransparent(false)
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
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

        val adapter = MainPagerAdapter(supportFragmentManager, fragments)
        view_page.adapter = adapter
        view_page.offscreenPageLimit = 2

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

    override fun onPageSelected(position: Int) {
        super.onPageSelected(position)
        view_page.currentItem = position
    }


}
