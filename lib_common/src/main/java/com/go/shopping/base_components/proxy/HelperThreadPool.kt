package com.go.shopping.base_components.proxy

import com.go.shopping.lib_base.thread_pool.ShoppingPoolExecutor
import com.go.shopping.lib_base.thread_pool.interfaces.IThreadProcessor

import java.util.concurrent.Future


/**
 * 线程池
 */
object HelperThreadPool : IThreadProcessor {


    override fun execute(runnable: Runnable) {
        ShoppingPoolExecutor.getInstance().execute(runnable)
    }

    override fun submit(runnable: Runnable): Future<*> {
        return ShoppingPoolExecutor.getInstance().submit(runnable)
    }

    /**
     *  当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态
     *  此时，则不能再往线程池中添加任何任务
     *  否则将会抛出RejectedExecutionException异常
     *  但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出。
     */
    override fun shutdown() {
        if (!ShoppingPoolExecutor.getInstance().isShutdown)
        ShoppingPoolExecutor.getInstance().shutdown()
    }

    /**
     *  执行该方法，线程池的状态立刻变成STOP状态，并试图停止所有正在执行的线程，不再处理还在池队列中等待的任务
     *  当然，它会返回那些未执行的任务。
     *  它试图终止线程的方法是通过调用Thread.interrupt()方法来实现的，
     *  但是大家知道，这种方法的作用有限，如果线程中没有sleep 、wait、Condition、定时锁等应用, interrupt()方法是无法中断当前的线程的
     *  所以，ShutdownNow()并不代表线程池就一定立即就能退出，它可能必须要等待所有正在执行的任务都执行完成了才能退出。
     */
    override fun shutdownNow() {
        if (!ShoppingPoolExecutor.getInstance().isShutdown)
        ShoppingPoolExecutor.getInstance().shutdownNow()
    }

}
