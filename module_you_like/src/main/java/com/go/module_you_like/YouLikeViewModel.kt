package com.go.module_you_like

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.go.module_you_like.data.YouLikeBean
import com.go.shopping.ui_base.BaseViewModel

class YouLikeViewModel : BaseViewModel() {
    private val _youLike = MutableLiveData<ArrayList<YouLikeBean>>()
    val youLikeBean: LiveData<ArrayList<YouLikeBean>> = _youLike


    /**
     * 测试
     */
    fun getList(position:Int) {
        if (position!=0){
            val list = ArrayList<YouLikeBean>()
            _youLike.value?.let { list.addAll(it) }
            list.addAll(data())
            _youLike.value = list
        }
        else{
            _youLike.value=data()
        }
    }
    operator fun <T> MutableLiveData<ArrayList<T>>.plusAssign(values: List<T>) {
        val value = this.value ?: arrayListOf()
        value.addAll(values)
        this.value = value
    }

    //////////////////////////////////////////////////////////////////////
    private var IMAGE1: String? =
        "https://gd3.alicdn.com/imgextra/i3/257311954/O1CN01dAAeIH1QIyQPlVIhQ_!!0-item_pic.jpg"
    private val IMAGE2 =
        "https://gd1.alicdn.com/imgextra/i1/257311954/TB2TWVaaCuFJuJjSZJiXXXC4XXa_!!257311954.jpg"
    private val IMAGE3 =
        "https://gd4.alicdn.com/imgextra/i1/3022241613/TB2YdDsiH_0UKFjy1XaXXbKfXXa_!!3022241613.jpg"
    private val IMAGE4 =
        "https://gd4.alicdn.com/imgextra/i2/0/TB1os7BRVXXXXavapXXXXXXXXXX_!!0-item_pic.jpg"
    private val IMAGE5 =
        "https://gd2.alicdn.com/imgextra/i1/73861778/TB28gVhu3JkpuFjSszcXXXfsFXa_!!73861778.jpg"

    private fun data(): ArrayList<YouLikeBean> {
        val indexBean = YouLikeBean(
            IMAGE1,
            "气质修身显瘦女装2017新款夏潮流印花名媛小香风鱼尾裙两件套装裙",
            1332,
            4329,
            1
        )
        val indexBean2 = YouLikeBean(
            IMAGE2,
            "夏季套装女装两件套2017新款韩版学生宽松潮流运动九分裤一套00后",
            473,
            4383,
            2
        )
        val indexBean1 = YouLikeBean(
            IMAGE3,
            "春季2017韩版女装新款夏装少女bf风",
            34,
            1221,
            4
        )
        val indexBean3 = YouLikeBean(
            IMAGE4,
            "2017新款修身显瘦韩版大码潮流女装女士紧身白色短袖t恤 女 夏款",
            232,
            1333,
            4
        )
        val indexBean4 = YouLikeBean(
            IMAGE5,
            "棉麻连衣裙中长款2017夏季新款女装亚麻宽松裙子时尚大码女装潮流",
            2213,
            1323,
            8
        )
        val arrayList = ArrayList<YouLikeBean>()
        arrayList.add(indexBean)
        arrayList.add(indexBean1)
        arrayList.add(indexBean4)
        arrayList.add(indexBean2)
        arrayList.add(indexBean3)
        arrayList.addAll(arrayList)
        arrayList.addAll(arrayList)
        arrayList.addAll(arrayList)
        return arrayList
    }
}
