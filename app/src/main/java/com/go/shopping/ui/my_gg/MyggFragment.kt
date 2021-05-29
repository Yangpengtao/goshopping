package com.go.shopping.ui.my_gg

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.go.shopping.R
import com.go.shopping.base_components.ui_base.BaseTitleFragment

class MyggFragment : BaseTitleFragment() {
    override fun setContentView(): Int {
        return R.layout.mygg_fragment
    }

    companion object {
        fun newInstance() = MyggFragment()
    }

    private lateinit var viewModel: MyggViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MyggViewModel::class.java)
    }
    override fun onResume() {
        super.onResume()
        setTitleColorTransparent(true)
    }
}
