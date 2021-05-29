package com.go.shopping.ui

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.go.shopping.R
import com.go.shopping.base_components.ui_base.BaseActivity
import com.go.shopping.base_components.ui_base.BaseTitleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitleColorTransparent(false)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(nav_view, navController)
        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_my_gg -> {
                    navController.navigate(R.id.navigation_my_gg)
                }
                R.id.navigation_store -> {
                    navController.navigate(R.id.navigation_store)
                }
                R.id.navigation_user_show -> {
                    navController.navigate(R.id.navigation_user_show)
                }
                R.id.navigation_you_like -> navController.navigate(R.id.navigation_you_like)
            }
            false
        }
    }

}
