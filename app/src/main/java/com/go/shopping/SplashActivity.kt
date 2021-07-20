package com.go.shopping

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.go.module_main.MainActivity
import com.go.shopping.animation.AnimationUtil
import com.go.shopping.databinding.ActivitySplashBinding
import com.go.shopping.listener.NoDoubleClickListener
import com.go.shopping.ui_base.BaseActivity
import com.go.shopping.utils.LogPrinter
import com.go.shopping.utils.ScreenUtils
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {
    private val mTAG = "SplashActivity"
    private lateinit var viewModel: SplashViewModel
    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Normal)
        super.onCreate(savedInstanceState)
        mBinding =
            DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        window.setBackgroundDrawableResource(R.drawable.splash_bg)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        //这里防止的是切换横竖屏，或者用户设置为小窗口操作时避免重复执行动画
        if (!viewModel.isLoad()!!) {
            viewModel.changeLoadStatus(true)
            viewModel.initQuestion()
            v_bg.post { AnimationUtil.startRevealAnim(v_bg) }
        }

        viewModel.questionBean.observe(this, Observer {
            mBinding.question = it
        })
        viewModel.answer.observe(this, Observer {
            mBinding.answer = it
            setViewStatus(it.viewId)
        })
        tv_a.setOnClickListener(clickListener)
        tv_b.setOnClickListener(clickListener)
        tv_c.setOnClickListener(clickListener)
        tv_d.setOnClickListener(clickListener)
    }
    private val clickListener = object : NoDoubleClickListener() {
        override fun onNoDoubleClick(v: View?) {
            if (!viewModel.isDone()) {
                val text = (v as TextView).text.toString()
                viewModel.compareAnswer(text, v.id)
            }
        }
    }

    /**
     * AppCompatCheckedTextView 图标 跟文字走，我想要在固定位置
     * drawable 设置padding也会影响到文字偏移
     */
    private fun setViewStatus(vId: Int) {
        //设置图标样式
        val optionStatus: ConstraintLayout.LayoutParams =
            mBinding.imgTag.layoutParams as ConstraintLayout.LayoutParams
        optionStatus.topToTop = vId
        optionStatus.bottomToBottom = vId
        optionStatus.rightToRight = vId
        optionStatus.marginEnd = ScreenUtils.dp2px(this, 10)
        mBinding.imgTag.layoutParams = optionStatus
    }

    fun View.goMain() {
        LogPrinter.warning(mTAG, "${this.id}")
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }

    override fun onPause() {
        super.onPause()
        LogPrinter.error(mTAG, "-------------onPause-----------------")
    }

    override fun onResume() {
        super.onResume()
        LogPrinter.error(mTAG, "-------------onResume-----------------")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        LogPrinter.error(mTAG, "-------------onAttachedToWindow-----------------")
    }

    override fun onStop() {
        super.onStop()
        LogPrinter.error(mTAG, "-------------onStop-----------------")
    }

}
