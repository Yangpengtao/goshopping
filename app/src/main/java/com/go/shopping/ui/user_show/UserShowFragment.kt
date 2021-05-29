package com.go.shopping.ui.user_show

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.go.shopping.R
import com.go.shopping.base_components.ui_base.BaseFragment

class UserShowFragment : BaseFragment() {

    companion object {
        fun newInstance() = UserShowFragment()
    }

    private lateinit var viewModel: UserShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_show_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserShowViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onResume() {
        super.onResume()
        setTitleColorTransparent(true)
    }
}
