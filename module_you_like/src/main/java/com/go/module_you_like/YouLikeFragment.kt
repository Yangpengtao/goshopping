package com.go.module_you_like

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.go.shopping.base_components.toute_table.RouteTable

@Route(path = RouteTable.YOU_LIKE__FRAGMENT)
class YouLikeFragment : Fragment() {


    private lateinit var viewModel: YouLikeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.you_like_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YouLikeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
