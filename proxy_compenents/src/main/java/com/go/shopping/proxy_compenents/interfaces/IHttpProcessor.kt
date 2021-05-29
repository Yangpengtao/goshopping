package com.go.shopping.proxy_compenents.interfaces

import java.io.File

/**
 * Created by admin on 2017/6/22.
 */

interface IHttpProcessor {
    //网络访问：POST,GET,DELETE,PUT,UPDATE
    //网络访问：POST,GET,DELETE,PUT,UPDATE
    fun _post(url: String, params: Map<String, Any>, callback: ICallback)

    fun _get(url: String, params: Map<String, Any>, callback: ICallback)
    fun _file(file: File, callback: ICallback)
}
