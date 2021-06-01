package com.go.shopping

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.base_components.ui_base.BaseActivity

@Route(path = "/fddfd/fdfdsfd")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun goMain(view: View) {
//        startActivity(Intent(this, MainActivity::class.java))
        ARouter.getInstance().build(RouteTable.MAIN_ACTITIVTY).navigation()
    }
}
