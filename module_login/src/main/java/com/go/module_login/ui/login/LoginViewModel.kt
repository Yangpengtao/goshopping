package com.go.module_login.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.go.lib_base1.network.HttpCallback
import com.go.module_login.data.model.LoggedInUser
import com.go.shopping.ui_base.BaseViewModel
import java.util.*

/**
 * 用户信息类逻辑处理
 */
 class LoginViewModel : BaseViewModel() {

    //登陆页的滑动验证
    var slitherVeriry: Boolean = false

    private val _loginForm = MutableLiveData<LoginResult>()
    val loginFormState: LiveData<LoginResult> = _loginForm

    fun loginForCode(username: String, code: String) {
        _loginForm.value = LoginResult(success = true)
        return

        if (!isUserNameValid(username)) {
            _loginForm.value = LoginResult(success = false)
        } else if (!isCodeValid(code)) {
            _loginForm.value = LoginResult(success = false)
        } else {
            val map = TreeMap<String, Any>()
            map.put("user_name", username)
            map.put("password", code)
            map.put("cityname", "北京")
            _post(LoginContants.LOGIN, map, object : HttpCallback<LoggedInUser>() {
                override fun onSuccess(objResult: LoggedInUser) {
                    _loginForm.value = LoginResult(success = true, data = objResult)
                }

                override fun onFailure(e: String) {
                    _loginForm.value = LoginResult(success = false, error = e)
                }
            })
        }
    }


    private fun isUserNameValid(username: String): Boolean {
        return if (username.length == 11) {
            Patterns.PHONE.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isCodeValid(code: String): Boolean {
        return code.isNotBlank()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }


    data class LoginResult(
        val data: LoggedInUser? = null,
        val error: String? = null,
        val success: Boolean = false
    )

}
