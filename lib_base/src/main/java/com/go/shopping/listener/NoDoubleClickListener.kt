package com.go.shopping.listener

import android.view.View

abstract class NoDoubleClickListener : View.OnClickListener {
    override fun onClick(v: View?) {
        onNoDoubleClick(v)
    }

    abstract fun onNoDoubleClick(v: View?)

}