package com.go.shopping.lib_base.network.interfaces


/**
 * 参考 统一网络回调接口
 */
interface ICallback {
    fun onSuccess(result: String)
    fun onFailure(e: String)
}
