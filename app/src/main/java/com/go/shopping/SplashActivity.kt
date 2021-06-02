package com.go.shopping

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.go.module_main.MainActivity
import com.go.shopping.base_components.ui_base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initBaseLib(applicationContext)
    }

    fun goMain(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
