package com.go.shopping.ui_base

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.go.shopping.R
import com.go.shopping.utils.statusbar.StatusBarUtil

abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setTitleColorTransparent(isTrans: Boolean) {
        when (isTrans) {
            false -> StatusBarUtil.setColorNoTranslucent(
                activity,
                ContextCompat.getColor(activity!!, R.color.colorPrimary)
            )
            true -> StatusBarUtil.setColorNoTranslucent(activity, Color.TRANSPARENT)
        }
    }
}

