package com.go.shopping.base_components.ui_base

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.go.shopping.base_components.R
import com.go.shopping.base_components.tools.statusbar.StatusBarUtil

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BaseFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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

