package com.go.lib_base1.thread_pool.interfaces

import java.util.concurrent.Future

interface IThreadProcessor {
    fun _execute(runnable: Runnable)
    fun _submit(runnable: Runnable): Future<*>


    fun _shutdown()

}