package com.go.module_login.ui.login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.CompoundButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.go.module_login.R
import com.go.module_login.weight.SlitherVerifyView
import com.go.shopping.base_components.tools.ToastUtil
import com.go.shopping.base_components.tools.statusbar.StatusBarUtil
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.base_components.ui_base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = RouteTable.LOGIN_ACTITIVTY)
class LoginActivity : BaseActivity(), View.OnClickListener, SlitherVerifyView.CallBack,
    CompoundButton.OnCheckedChangeListener {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setTitleColorTransparent(false)
        setListener()
        initBaseLib(this)
        loginViewModel = ViewModelProviders.of(this)
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer
            if (loginState.success) {
                ToastUtil.show(this, "登陆成功！")
                ARouter.getInstance().build(RouteTable.MAIN_ACTITIVTY).navigation()
                finish()
            } else {
                ToastUtil.show(this, "登陆失败！")
            }
        })
    }

    private fun setListener() {
        v_slither_verify.setCallBack(this)
        btnLogin.setOnClickListener(this)
        tvGoPasswordLogin.setOnClickListener(this)
        tvGoVerifyCodeLogin.setOnClickListener(this)
        tvForgetPassword.setOnClickListener(this)
        v_slither_verify.setCallBack(this)
        cbPassword.setOnCheckedChangeListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btnLogin -> {
                if (loginViewModel.slitherVeriry){
                    loginViewModel.loginForCode(etUserPhone.text.toString(), etCode.text.toString())
                }else{
                    ToastUtil.show(this, "请先滑动验证")
                }
            }
            R.id.tvGoPasswordLogin -> {
                showPasswordLogin()
            }
            R.id.tvGoVerifyCodeLogin -> {
                showVerifyLogin()
            }
            R.id.tvForgetPassword -> {
            }
        }
    }

    override fun pass() {
        loginViewModel.slitherVeriry = true
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when (p0!!.id) {
            R.id.cbPassword -> {
                if (p1) {
                    etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                } else {
                    etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }
        }
    }

    /**
     * 显示密码登陆
     */
    private fun showPasswordLogin() {
        etPassword.visibility = View.VISIBLE
        cbPassword.visibility = View.VISIBLE
        rlPassLogin.visibility = View.VISIBLE
        etCode.visibility = View.GONE
        tvGetVerifyCode.visibility = View.GONE
        tvGoPasswordLogin.visibility = View.GONE
        btnLogin.text = getString(R.string.login_login)
    }

    private fun showVerifyLogin() {
        etPassword.visibility = View.GONE
        cbPassword.visibility = View.GONE
        rlPassLogin.visibility = View.GONE
        etCode.visibility = View.VISIBLE
        tvGetVerifyCode.visibility = View.VISIBLE
        tvGoPasswordLogin.visibility = View.VISIBLE
        btnLogin.text = getString(R.string.login_login_register)
    }
}
