package com.go.module_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter.getInstance
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.ui_base.BasePagerActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_bottom_view.*

/**
 * 现在手动滑动的时候，稍微一滑动第二个数据就开始加载，是因为数据都在OnCreatedView里加载的数据
 * 可以换成在OnResume里判断进行懒加载
 * 必须实现，不然在滑动的时候就加载数据，会卡的  //TODO 重要
 */
@Route(path = RouteTable.MAIN_ACTIVITY)
class MainActivity : BasePagerActivity() {
    private lateinit var youLike: Fragment
    private lateinit var userShow: Fragment
    private lateinit var mygg: Fragment
    private lateinit var home: Fragment
    //标识viewpager是否执行平滑动画，点击底部菜单不执行，自己手动滑动执行
    var isSmoothScroll = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleColorTransparent(false)
        val fragments = initFragment()
        val adapter = MainPagerAdapter(this, fragments)
        view_page.adapter = adapter
//        view_page.isUserInputEnabled = false
        listener()
    }


    /**
     * viewpage和navView绑定联动
     */
    private fun listener() {
        btn_home.setOnClickListener(bottomViewClickListener)
        btn_user_show.setOnClickListener(bottomViewClickListener)
        btn_you_like.setOnClickListener(bottomViewClickListener)
        btn_my_gg.setOnClickListener(bottomViewClickListener)

        view_page.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                isSmoothScroll = true
                setPosition(position)
            }
        })
    }

    /**
     * 仅为bottomView提供
     */
    private val bottomViewClickListener = View.OnClickListener {
        //将滑动动画去掉
        isSmoothScroll = false
        when (it.id) {
            R.id.btn_home -> setPosition(0)
            R.id.btn_you_like ->setPosition(1)
            R.id.btn_user_show -> setPosition(2)
            R.id.btn_my_gg -> setPosition(3)
        }
    }

    private fun setPosition(position: Int) {
        view_page.setCurrentItem(position, isSmoothScroll)
        //这里可做判断，保存一下前一次的position,这里就一视同仁了,源码如果没判断，就够了
        btn_home.isSelected = false
        btn_you_like.isSelected = false
        btn_user_show.isSelected = false
        btn_my_gg.isSelected = false
        when(position){
            0-> btn_home.isSelected = true
            1-> btn_you_like.isSelected = true
            2-> btn_user_show.isSelected = true
            3-> btn_my_gg.isSelected = true
        }
    }

    /**
     * 初始化四个fragment
     */
    private fun initFragment(): Array<Fragment?> {
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
        return fragments
    }
}
