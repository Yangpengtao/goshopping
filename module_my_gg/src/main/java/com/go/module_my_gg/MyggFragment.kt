package com.go.module_my_gg

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.utils.LogPrinter
import kotlinx.android.synthetic.main.fragment_mygg.*

@Route(path = RouteTable.MY_GG_FRAGMENT)
class MyggFragment : Fragment() {
    val TAG = "MyggFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mygg, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAdd.setOnClickListener {
            ARouter.getInstance().build(RouteTable.LOGIN_ACTIVITY).navigation()
        }
        LogPrinter.error(TAG, "-------onActivityCreated------------")
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogPrinter.error(TAG, "-------onAttach------------")
    }
    override fun onDestroy() {
        super.onDestroy()
        LogPrinter.error(TAG, "---------onDestroy------------")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogPrinter.warning(TAG,"-----onCreate-----")

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
