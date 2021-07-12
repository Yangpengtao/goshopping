package com.go.shopping.ui_base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.go.shopping.R
import kotlinx.android.synthetic.main.activity_base.*

@Deprecated("该类嵌套太多，已过时")
abstract class BaseTitleFragment: BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return getContentView(container)
    }

    /**
     * 返回 layoutId
     */
    abstract fun setContentView() :Int

    fun getContentView(container: ViewGroup?):View?{
        val viewRoot = LayoutInflater.from(activity).inflate(R.layout.activity_base, container, false)
        val mContainer = viewRoot.findViewById<FrameLayout>(R.id.content_view)
        val contentView = LayoutInflater.from(activity).inflate(setContentView(), container, false)
        mContainer.addView(contentView)
        return viewRoot
    }

    /**
     * 设置标题栏显示状态
     *
     * @param type 显示类型
     */
    fun setTitleVisibility(type: Int) {
        title_parent.visibility = type
    }

    /**
     * 设置标题栏显示状态
     *
     * @param color 颜色
     */
    fun setTitleBgCorlor(color: Int) {
        title_parent.setBackgroundColor(color)
    }


    /**
     * 得到左边text
     *
     * @return
     */
    fun getLeftText_(): TextView {
        return title_left_text
    }

    /**
     * 得到左边img
     *
     * @getRightText_
     */
    fun getLeftImg_(): ImageView {
        return title_left_img
    }

    /**
     * 得到title
     *
     * @return
     */
    fun getTitle_(): TextView {
        return title_content
    }

    /**
     * 得到右侧text
     *
     * @return
     */
    fun getRightText_(): TextView {
        return title_right_text
    }

    /**
     * 得到右侧img
     *
     * @return
     */
    fun getRightImg_(): ImageView {
        return title_right_img
    }


    /**
     * 显示内容
     */
    fun showContent() {
        tv_empty.visibility = View.GONE
        tv_network_error.visibility = View.GONE
        pgb_loading.visibility = View.GONE
    }

    /**
     * 显示加载中
     */
    fun showLoading() {
        tv_empty.visibility = View.GONE
        tv_network_error.visibility = View.GONE
        pgb_loading.visibility = View.VISIBLE
    }

    /**
     * 显示空布局
     */
    fun showEmpty() {
        tv_empty.visibility = View.VISIBLE
        tv_network_error.visibility = View.GONE
        pgb_loading.visibility = View.GONE
    }

    /**
     * 显示空布局
     */
    fun showNetworkError() {
        tv_empty.visibility = View.GONE
        tv_network_error.visibility = View.VISIBLE
        pgb_loading.visibility = View.GONE
    }
}