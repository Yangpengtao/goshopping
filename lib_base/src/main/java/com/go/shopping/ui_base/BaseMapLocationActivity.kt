package com.go.shopping.ui_base

import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationListener

abstract class BaseMapLocationActivity : BaseActivity(), AMapLocationListener {
    override fun onLocationChanged(p0: AMapLocation?) = Unit
}


