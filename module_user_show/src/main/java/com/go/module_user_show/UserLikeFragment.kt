package com.go.module_user_show

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.utils.LogPrinter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [UserLikeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [UserLikeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Route(path = RouteTable.USER_SHOW_FRAGMENT)
class UserLikeFragment : Fragment() {

    val TAG="UserLikeFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        LogPrinter.error(TAG, "-------onCreateView------------")
        return inflater.inflate(R.layout.fragment_user_like, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogPrinter.error(TAG, "-------onAttach------------")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogPrinter.error(TAG, "-------onActivityCreated------------")

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
