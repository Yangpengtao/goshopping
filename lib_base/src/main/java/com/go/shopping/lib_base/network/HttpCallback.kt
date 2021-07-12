@file:Suppress("UNCHECKED_CAST")
package com.go.shopping.lib_base.network

import com.google.gson.Gson

import java.lang.reflect.ParameterizedType

import com.go.lib_base1.network.interfaces.ICallback

/**
 * 统一数据处理类
 */
abstract class HttpCallback<Result> : ICallback {

    override fun onSuccess(result: String) {
        val gson = Gson()
        val clz = analysisClassInfo(this)
        val objResult = gson.fromJson(result, clz) as Result
        onSuccess(objResult)
        PrinterNetwork.e("TAG", objResult.toString())
    }

    abstract fun onSuccess(objResult: Result)

    override fun onFailure(e: String) {
//        ToastUtil.show("联网失败！")
    }

    private fun analysisClassInfo(obj: Any): Class<*> {
        val getType = obj.javaClass.genericSuperclass
        val params = (getType as ParameterizedType).actualTypeArguments
        return params[0] as Class<*>
    }
}
