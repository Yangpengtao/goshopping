package com.go.shopping

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.go.module_main.MainActivity
import com.go.shopping.animation.AnimationUtil
import com.go.shopping.listener.NoDoubleClickListener
import com.go.shopping.proxy.HelperSharedPreference
import com.go.shopping.question.QuestionBean
import com.go.shopping.question.QuestionConfig
import com.go.shopping.ui_base.BaseActivity
import com.go.shopping.utils.LogPrinter
import com.go.shopping.utils.ScreenUtils
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : BaseActivity() {
    private val mTAG = "SplashActivity"
    private var questionBean: QuestionBean? = null
    private var isDo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Normal)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setBackgroundDrawableResource(R.drawable.splash_bg)
        initQuestion()
        v_bg.post { AnimationUtil.startRevealAnim(v_bg) }
        tv_a.setOnClickListener(clickListener)
        tv_b.setOnClickListener(clickListener)
        tv_c.setOnClickListener(clickListener)
        tv_d.setOnClickListener(clickListener)
    }

    private val clickListener = object : NoDoubleClickListener() {
        override fun onNoDoubleClick(v: View?) {
            if (!isDo) {
                setViewStatus(v!!)
            }
        }

    }

    /**
     * AppCompatCheckedTextView 图标 跟文字走，我想要在固定位置
     * drawable 设置padding也会影响到文字偏移
     */
    private fun setViewStatus(v: View) {
        //设置图标样式
        val optionStatus: ConstraintLayout.LayoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        optionStatus.topToTop = v.id
        optionStatus.bottomToBottom = v.id
        optionStatus.rightToRight = v.id
        optionStatus.marginEnd=ScreenUtils.dp2px(this, 10)
        //初始化图标
        val mStatusImageView = ImageView(this)
        if (questionBean?.answer == (v as TextView).text) {
            mStatusImageView.setImageResource(R.drawable.option_true)
        } else {
            mStatusImageView.setImageResource(R.drawable.option_false)
        }
        mStatusImageView.layoutParams = optionStatus
        container.addView(mStatusImageView)
        isDo = true
        //回答完毕，显示答案提示和进入按钮
        tv_ps.text = questionBean?.tip
        btn_enter.visibility = View.VISIBLE
    }

    fun initQuestion() {
        var with = HelperSharedPreference.getInt("question_with", 1)
        questionBean = QuestionConfig.questionList[with]
        if (HelperSharedPreference.getInt(
                "question_with",
                1
            ) == QuestionConfig.questionList.size()
        ) {
            HelperSharedPreference.putData("question_with", 1)
        } else {
            HelperSharedPreference.putData("question_with", ++with)
        }
        tv_question.text = questionBean?.question
        tv_a.text = questionBean?.optionA
        tv_b.text = questionBean?.optionB
        tv_c.text = questionBean?.optionC
        tv_d.text = questionBean?.optionD
        LogPrinter.warning(mTAG, "question is ok!")
    }


    fun View.goMain() {
        LogPrinter.warning(mTAG, "${this.id}")
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}
