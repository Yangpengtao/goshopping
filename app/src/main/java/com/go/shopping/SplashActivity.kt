package com.go.shopping

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.go.module_main.MainActivity
import com.go.shopping.proxy.HelperSharedPreference
import com.go.shopping.question.QuestionConfig
import com.go.shopping.ui_base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash.view.*

class SplashActivity : BaseActivity() {
    override fun onAttachedToWindow() {
        setTitleColorTransparent(false)
        super.onAttachedToWindow()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Normal);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setBackgroundDrawableResource(R.color.colorPrimary)
        var with=HelperSharedPreference.getInt("question_with",1);
        val questionBean = QuestionConfig.questionList[with]
        if (HelperSharedPreference.getInt("question_with",1)==QuestionConfig.questionList.size()){
            HelperSharedPreference.putData("question_with",1)
        }else{
            HelperSharedPreference.putData("question_with",++with)
        }
        tv_question.text=questionBean.question
        tv_a.text=questionBean.optionA
        tv_b.text=questionBean.optionB
        tv_c.text=questionBean.optionC
        tv_d.text=questionBean.optionD
    }

    fun View.goMain() {
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        finish()
    }
}
