package com.go.shopping.ui.you_like

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.go.shopping.R

class YouLikeFragment : Fragment() {

    companion object {
        fun newInstance() = YouLikeFragment()
    }

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
