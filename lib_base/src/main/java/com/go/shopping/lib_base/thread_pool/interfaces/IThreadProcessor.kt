package com.go.shopping.lib_base.thread_pool.interfaces

import java.util.concurrent.Future

interface IThreadProcessor {
    fun execute(runnable: Runnable)
    fun executeSingle(runnable: Runnable)
    fun submit(runnable: Runnable): Future<*>
    fun submitSingle(runnable: Runnable): Future<*>
    fun shutdown()
    fun shutdownNow()
}