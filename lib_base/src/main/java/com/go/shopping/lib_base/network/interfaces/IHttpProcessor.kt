package com.go.shopping.lib_base.network.interfaces

import java.io.File

/**
 * 网络请求所用到的方法
 */
interface IHttpProcessor {
    //网络访问：POST,GET,DELETE,PUT,UPDATE
    fun post(url: String, params: Map<String, Any>, callback: ICallback)

    fun get(url: String, params: Map<String, Any>, callback: ICallback)
    fun file(file: File, callback: ICallback)
}
