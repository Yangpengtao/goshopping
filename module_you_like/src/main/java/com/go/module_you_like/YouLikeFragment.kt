package com.go.module_you_like

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.go.module_you_like.data.YouLikeBean
import com.go.module_you_like.mydialog.DialogActivity
import com.go.shopping.utils.ToastUtil
import com.go.shopping.base_components.toute_table.RouteTable
import com.go.shopping.ui_base.BaseTitleFragment
import com.go.shopping.ui_base.adapter.BaseAdapter
import com.go.shopping.ui_base.adapter.BaseViewHolder
import com.go.shopping.ui_base.adapter.RecyclerViewUtils
import com.go.shopping.ui_base.adapter.SpacesItemDecoration
import com.go.shopping.utils.LogPrinter
import kotlinx.android.synthetic.main.you_like_fragment.*
import java.util.*

@Route(path = RouteTable.YOU_LIKE__FRAGMENT)
class YouLikeFragment : BaseTitleFragment() {
    val TAG = "YouLikeFragment"


    private lateinit var viewModel: YouLikeViewModel
    private lateinit var resyUtils: RecyclerViewUtils
    private lateinit var listAdapter1: BaseAdapter<YouLikeBean>
    var position = 1

    override fun setContentView(): Int {
        return R.layout.you_like_fragment
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YouLikeViewModel::class.java)
        //set srl scheme color
        srl.setColorSchemeColors(ContextCompat.getColor(activity!!, R.color.colorPrimary))
        //set title
        setTitle()
        //set recycleView
        setRecycleView()
        //loading data
        loadData()
        viewModel.getList(0)
        viewModel.youLikeBean.observe(activity!!, androidx.lifecycle.Observer {
            if (position == 0) {
                ToastUtil.show(activity!!, "已经是最新数据")
                listAdapter1.setmData(it)
            } else {
                listAdapter1.setmData(it, position)
            }
        })


        LogPrinter.error(TAG,"我走了onCreateView")
    }


    override fun onDestroy() {
        super.onDestroy()
        LogPrinter.error(TAG,"我走了onDestroy")

    }
    /**
     * 数据加载
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun loadData() {
        recyclerView.setOnScrollChangeListener { _, _, _, _, _ ->
            if (!recyclerView.canScrollVertically(1)) {
                position = viewModel.youLikeBean.value!!.size
                viewModel.getList(position)
                //上拉加载
            }
        }
        srl.setOnRefreshListener {
            //下拉刷新
            position = 0
            viewModel.getList(position)
            srl.isRefreshing = false
        }
    }

    /**
     * 设置列表
     */
    private fun setRecycleView() {
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE)
        recyclerView.layoutManager = staggeredGridLayoutManager
        //设置item之间的间隔
        val decoration = SpacesItemDecoration(10)
        recyclerView.addItemDecoration(decoration)
        (Objects.requireNonNull<Any?>(recyclerView.itemAnimator) as DefaultItemAnimator).supportsChangeAnimations =
            false
        (Objects.requireNonNull<Any?>(recyclerView.itemAnimator) as SimpleItemAnimator).supportsChangeAnimations =
            false
        recyclerView.itemAnimator!!.changeDuration = 0
        //疯转了recycle_view的点击和长安事件
        resyUtils = RecyclerViewUtils(activity, recyclerView)
        listAdapter1 = object : BaseAdapter<YouLikeBean>(
            R.layout.you_like_list_item,
            viewModel.youLikeBean.value
        ) {
            override fun onBindViewHolder(
                holder: BaseViewHolder,
                data: ArrayList<YouLikeBean>?,
                position: Int
            ) {
                data!![position].img?.let { holder.setImage(R.id.index_item_img, it) }!!
                    .setText(R.id.tvDays, "上架" + data[position].days.toString() + "天")
                data[position].text?.let { holder.setText(R.id.index_item_tv, it) }!!
                    .setText(R.id.tvFavNum, data[position].like_num.toString())
                    .setText(R.id.tvLikeNum, data[position].like_num.toString())
            }
        }
        listAdapter1.setmData(data = viewModel.youLikeBean.value)
        recyclerView.adapter = listAdapter1

        resyUtils.setOnItemLongClickListener { i: Int, view: View ->
            val intent = Intent(activity, DialogActivity::class.java)
            val imgs = ArrayList<String>()
            viewModel.youLikeBean.value?.get(i)!!.img?.let { imgs.add(it) }
            imgs.add("https://gd2.alicdn.com/imgextra/i4/391052286/TB2.5dxvbJmpuFjSZFwXXaE4VXa_!!391052286.jpg_400x400.jpg")
            imgs.add("https://gd4.alicdn.com/imgextra/i3/142722258/TB2ruOcvdFopuFjSZFHXXbSlXXa_!!142722258.jpg")
            imgs.add("https://gd1.alicdn.com/imgextra/i3/20868741/TB2.3jWziRnpuFjSZFCXXX2DXXa_!!20868741.jpg")
            imgs.add("https://gd4.alicdn.com/imgextra/i1/704298669/TB2WoNVwhXlpuFjSsphXXbJOXXa_!!704298669.jpg")
            val data = Bundle()
            data.putStringArrayList("goodImgs", imgs)
            intent.putExtra("goodImgs", data)
            startActivity(intent)
        }
    }

    /**
     * 设置标题
     */
    private fun setTitle() {
        setTitleVisibility(View.VISIBLE)
        getTitle_().text = getString(R.string.title_you_like)
        getRightText_().visibility = View.VISIBLE
        getRightText_().text = getString(R.string.category)
    }
}
