package com.go.shopping.ui_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.go.shopping.lib_base.network.interfaces.ICallback
import com.go.shopping.lib_base.network.interfaces.IHttpProcessor
import java.io.File


/**
 * 待优化
 */
abstract class BaseViewModel : ViewModel(),
    IHttpProcessor {

    private val _isLoad = MutableLiveData<Boolean>(false)
    val isLoad: LiveData<Boolean> = _isLoad

    fun changeLoadStatus(load: Boolean) {
        _isLoad.value = load
    }

    fun isLoad() = _isLoad.value

    override fun file(file: File, callback: ICallback) {
//        HelperHttp._file(file, callback)
    }

    override fun post(url: String, params: Map<String, Any>, callback: ICallback) {
//        HelperHttp._post(url, params, callback)
    }

    override fun get(url: String, params: Map<String, Any>, callback: ICallback) {
//        HelperHttp._get(url, params, callback)
    }

}