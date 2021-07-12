package com.go.shopping.lib_base.thread_pool;

import com.go.shopping.lib_base.thread_pool.thread_factory.ShoppingThreadFactory;
import com.go.shopping.utils.Consts;
import com.go.shopping.utils.LogPrinter;
import com.go.shopping.utils.TextUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YPT
 * @date 2021/7/12
 */
public class ShoppingSinglePoolExecutor extends ThreadPoolExecutor {

    private static final int INIT_THREAD_COUNT =   1;
    private static final int MAX_THREAD_COUNT = 1;
    private static final long SURPLUS_THREAD_LIFE = 0L;

    private static ShoppingSinglePoolExecutor instance;

    public static ShoppingSinglePoolExecutor getInstance() {
        if (null == instance) {
            synchronized (ShoppingPoolExecutor.class) {
                if (null == instance) {
                    instance = new ShoppingSinglePoolExecutor(
                            INIT_THREAD_COUNT,
                            MAX_THREAD_COUNT,
                            SURPLUS_THREAD_LIFE,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<Runnable>(4),
                            new ShoppingThreadFactory());
                }
            }
        }
        return instance;
    }

    private ShoppingSinglePoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                LogPrinter.INSTANCE.error(Consts.TAG, "Task rejected, too many task!");
            }
        });
    }

    /*
     *  线程执行结束，顺便看一下有么有什么乱七八糟的异常
     *
     * @param r the runnable that has completed
     * @param t the exception that caused termination, or null if
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t == null && r instanceof Future<?>) {
            try {
                ((Future<?>) r).get();
            } catch (CancellationException ce) {
                t = ce;
            } catch (ExecutionException ee) {
                t = ee.getCause();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset
            }
        }
        if (t != null) {
            LogPrinter.INSTANCE.warning(Consts.TAG, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + t.getMessage() + "]\n" + TextUtils.formatStackTrace(t.getStackTrace()));
        }
    }

}
