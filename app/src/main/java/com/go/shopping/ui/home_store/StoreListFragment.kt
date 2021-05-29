package com.go.shopping.ui.home_store

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.go.shopping.R
import com.go.shopping.base_components.ui_base.BaseFragment

class StoreListFragment : BaseFragment() {

    companion object {
        fun newInstance() = StoreListFragment()
    }

    private lateinit var viewModel: StoreListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.store_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StoreListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
         setTitleColorTransparent(false)
    }



}
