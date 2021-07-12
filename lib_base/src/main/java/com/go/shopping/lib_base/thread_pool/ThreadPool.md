## 队列(具体点击去看源码)
 - ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列 默认构造ArrayBlockingQueue(int capacity)
 - LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列。默认构造LinkedBlockingQueue() { this(Integer.MAX_VALUE);  }
 - PriorityBlockingQueue：一个支持优先级排序的无界阻塞队列。默认构造：PriorityBlockingQueue() {  this(DEFAULT_INITIAL_CAPACITY, null);  } DEFAULT_INITIAL_CAPACITY = 11
 - DelayQueue：一个使用优先级队列实现的无界阻塞队列。public DelayQueue() {}  该队列的节点必须要继承Delay类
 - SynchronousQueue：一个不存储元素的阻塞队列。 默认构造：SynchronousQueue(){this(false)}  public SynchronousQueue(boolean fair){} fair 如果为true遵循FIFO原则，否则进来一个节点会先尝试不经过队列直接给线程处理
 - LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。 LinkedTransferQueue() {} 重点：无界队列
 - LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。  public LinkedBlockingDeque() { this(Integer.MAX_VALUE); } 首先它是有界的，默认为整形最大值。他的特点是可以头进，头取，尾插，尾取
 
|方法/处理方式|抛出异常  |返回特殊值 |一直阻塞 | 超时退出|
|--|--|--|--|--| 
| 插入方法 | add(e)     | offer(e)   |put(e)    | offer(e,time,unit)  |
| 移除方法 | remove() | poll()       |take()    |pull(time,unit)       |
| 检查方法 | element()| peek()     |不可用  |不可用                  |
 ## 四个已封装好的线程池
 - newSingleThreadExecutor
    默认构造函数 ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>()));
    “解释”：核心线程数为1，最大线程数为1即本线程数只有1个线程，使用的是链表有界队列
    两个主要API：
            - invokeAll(Collection<? extends Callable<T>> tasks) 执行 集合里所有并返回集合返回值
            - invokeAny(Collection<? extends Callable<T>> tasks)执行 集合里其中一个并返回返回值
 
 - newCachedThreadPool
    默认构造函数 ThreadPoolExecutor() -> newCachedThreadPool(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    “解释”：无核心函数，表名队列直接提交给非核心线程执行，空闲线程60秒无任务便执行销毁，使用不存储元素的阻塞队列。
    两个主要API：
        - invokeAll(Collection<? extends Callable<T>> tasks) 执行 集合里所有并返回集合返回值
        - invokeAny(Collection<? extends Callable<T>> tasks)执行 集合里其中一个并返回返回值
 
 - newFixedThreadPool
    默认构造函数 ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    “解释”：核心线程和最大线程一样，所以不需要设定空闲线程回收时间，使用的队列是链表有界阻塞队列
    两个主要API：
        - invokeAll(Collection<? extends Callable<T>> tasks) 执行 集合里所有并返回集合返回值
        - invokeAny(Collection<? extends Callable<T>> tasks)执行 集合里其中一个并返回返回值
 
 - newScheduledThreadPool
    默认构造函数 newScheduledThreadPool(int corePoolSize)-> super(corePoolSize, Integer.MAX_VALUE, DEFAULT_KEEP_ALIVE_MILLIS, MILLISECONDS, new DelayedWorkQueue());
    "解释"：必须传一个核心线程数，DEFAULT_KEEP_ALIVE_MILLIS=10，
    三个主要API:
        - schedule  经过一段时间执行，执行一次。    两个重载方法，一个是传入Runnable，一个是传入Callable，在加上时间和时间单位
        - scheduleWithFixedDelay  先执行一次，在经过特定时间周期循环
        - scheduleAtFixedRate      经过特定时间后开始周期循环