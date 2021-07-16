package com.go.shopping.ui_base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.go.lib_base1.network.interfaces.ICallback
import com.go.lib_base1.network.interfaces.IHttpProcessor
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

    override fun _file(file: File, callback: ICallback) {
//        HelperHttp._file(file, callback)
    }

    override fun _post(url: String, params: Map<String, Any>, callback: ICallback) {
//        HelperHttp._post(url, params, callback)
    }

    override fun _get(url: String, params: Map<String, Any>, callback: ICallback) {
//        HelperHttp._get(url, params, callback)
    }

}