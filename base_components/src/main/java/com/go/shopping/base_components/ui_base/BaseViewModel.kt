package com.go.shopping.base_components.ui_base

import androidx.lifecycle.ViewModel
import com.go.shopping.proxy_compenents.HelperHttp
import com.go.shopping.proxy_compenents.interfaces.ICallback
import com.go.shopping.proxy_compenents.interfaces.IHttpProcessor
import java.io.File

abstract class BaseViewModel : ViewModel(), IHttpProcessor {
    override fun _file(file: File, callback: ICallback) {
        HelperHttp ._file(file, callback)
    }

    override fun _post(url: String, params: Map<String, Any>, callback: ICallback) {
        HelperHttp ._post(HelperHttp.BASE_URL + url, params, callback)
    }

    override fun _get(url: String, params: Map<String, Any>, callback: ICallback) {
        HelperHttp ._get(HelperHttp.BASE_URL + url, params, callback)
    }

}