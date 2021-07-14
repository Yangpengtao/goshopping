package com.go.module_home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.ui_base.BaseFragment
import com.go.shopping.utils.LogPrinter


@Route(path = RouteTable.HOME_FRAGMENT)
class HomeFragment : BaseFragment() {

    val TAG="homeFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        LogPrinter.warning(TAG,"-----onCreateView-----")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    //TODO 在这里初始化
    override fun loadData() {

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogPrinter.error(TAG, "-------onActivityCreated------------")

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogPrinter.error(TAG, "-------onAttach------------")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogPrinter.warning(TAG,"-----onCreate-----")

    }
    override fun onDestroy() {
        super.onDestroy()
        LogPrinter.error(TAG, "---------onDestroy------------")
    }
    override fun onResume() {
        super.onResume()
        LogPrinter.warning(TAG,"-----onResume-----")
    }

    override fun onPause() {
        super.onPause()
        LogPrinter.warning(TAG,"-----onPause-----")
    }

}
