package com.go.shopping

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.go.shopping.data.AnswerDoneResult
import com.go.shopping.data.QuestionBean
import com.go.shopping.proxy.HelperSharedPreference
import com.go.shopping.question.QuestionConfig
import com.go.shopping.ui_base.BaseViewModel


//必须像这样写，有效防止了在activity里操作数据（因为在activity操作不到这里面的值，哈哈哈哈）
//原因：只能操作下划线开头的，他才是实现类，而向外暴漏的是LiveData的抽象类
class SplashViewModel : BaseViewModel() {
    private val _answer = MutableLiveData<AnswerDoneResult>(AnswerDoneResult())
    val answer: LiveData<AnswerDoneResult> = _answer

    private val _questionBean = MutableLiveData<QuestionBean>()
    val questionBean: LiveData<QuestionBean> = _questionBean


    fun compareAnswer(text: String, id: Int) {
        if (_questionBean.value == null) return
        val result = _questionBean.value!!.answer == text
        _answer.value =
            AnswerDoneResult(
                isDone = true,
                result = result,
                explain = _questionBean.value!!.tip,
                viewId = id
            )
    }

    fun isDone(): Boolean {
        return _answer.value!!.isDone
    }

    fun initQuestion() {
        var with = HelperSharedPreference.getInt("question_with", 1)
        _questionBean.value = QuestionConfig.questionList[with]
        if (HelperSharedPreference.getInt(
                "question_with",
                1
            ) == QuestionConfig.questionList.size()
        ) {
            HelperSharedPreference.putData("question_with", 1)
        } else {
            HelperSharedPreference.putData("question_with", ++with)
        }

    }

}