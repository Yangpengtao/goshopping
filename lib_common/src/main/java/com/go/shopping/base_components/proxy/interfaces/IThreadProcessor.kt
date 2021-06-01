package com.go.shopping.base_components.proxy.interfaces

import java.util.concurrent.Future

interface IThreadProcessor {
    fun _execute(runnable: Runnable)
    fun _submit(runnable: Runnable): Future<*>


    fun _shutdown()

}