package com.go.shopping.base_components.ui_base

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.go.lib_base1.image.GlideProcessor
import com.go.lib_base1.network.okhttp.OKHttpProcessor
import com.go.lib_base1.shared_preference.SharedPreferenceProcessor
import com.go.shopping.base_components.R
import com.go.shopping.base_components.proxy.HelperHttp
import com.go.shopping.base_components.proxy.HelperImageLoader
import com.go.shopping.base_components.proxy.HelperSharedPreference
import com.go.shopping.base_components.tools.PermissionUtils
import com.go.shopping.base_components.tools.statusbar.StatusBarUtil

/**
 * 基础类
 */
abstract class BaseActivity : AppCompatActivity(), PermissionUtils.PermissiontCallBack {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        window.setBackgroundDrawable(null)
        Color.TRANSPARENT
    }


    fun setTitleColorTransparent(isTrans: Boolean) {
        when (isTrans) {
            false -> StatusBarUtil.setColorNoTranslucent(
                this,
                ContextCompat.getColor(this, R.color.colorPrimary)
            )
            true -> StatusBarUtil.setColorNoTranslucent(this, Color.TRANSPARENT)
        }
    }


    fun startActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        super.startActivity(intent)
    }

    fun startActivityString(clazz: Class<*>, vararg arg: String) {
        val intent = Intent(this, clazz)
        var i = 1
        val bundle: Bundle = Bundle()
        for (o: String in arg) {
            bundle.putString("param$i", o)
            i++
        }
        intent.putExtras(bundle)
        super.startActivity(intent)
    }

    fun startActivityInt(clazz: Class<*>, vararg arg: Int) {
        val intent = Intent(this, clazz)
        var i = 1
        val bundle: Bundle = Bundle()
        for (o: Int in arg) {
            bundle.putInt("param$i", o)
            i++
        }
        intent.putExtras(bundle)
        super.startActivity(intent)
    }

    fun View.backPage() {
        finish()
    }

    private var toast: Toast? = null
    fun showToast(str: String) {
        runOnUiThread {
            if (toast != null) {
                toast!!.cancel()
            }
            toast = Toast.makeText(this, str, Toast.LENGTH_SHORT)
            toast!!.show()
        }
    }

    override fun permissionSuccess() {
    }

    override fun permissionFailed() {
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PermissionUtils.init()!!.permissionAllRequestCode) {
            var isAllGranted = true
            for (grant: Int in grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false
                    break
                }
            }
            if (isAllGranted) {
                // 如果所有的权限都授予了, 则执行备份代码
                permissionSuccess()
            } else {
                permissionFailed()
            }
        }
    }

    fun initBaseLib(context: Context) {
        HelperHttp.init(OKHttpProcessor(context))
        HelperSharedPreference.init(SharedPreferenceProcessor(context))
        HelperImageLoader.init(GlideProcessor)
    }


}