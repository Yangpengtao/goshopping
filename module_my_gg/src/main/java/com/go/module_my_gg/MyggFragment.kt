package com.go.module_my_gg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.go.shopping.base_components.toute_table.RouteTable
import kotlinx.android.synthetic.main.fragment_mygg.*

@Route(path = RouteTable.MY_GG_FRAGMENT)
class MyggFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mygg, container, false)
    }

    var i = 0
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btnAdd.setOnClickListener {
            i++
            tv_empty.text = " i'm is " + i


        }
    }


}
