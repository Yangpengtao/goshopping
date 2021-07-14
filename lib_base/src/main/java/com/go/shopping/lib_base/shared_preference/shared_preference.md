## 特点
    - 基于单个xml文件实现
    - 轻量级持久化，不要存大数据
    - 多进程建议不要使用MODE_MULTI_PROCESS参数已过时，建议使用ContentProvider
    - 第一次获取，会全部读取到内存
    
## 使用
调用 context.getSharedPreferences("happy_shopping", Context.MODE_MULTI_PROCESS)会把xml文件全部读取到内存中，
建议：1，使用工作内存读取。2，分文件管理，保证每个sp文件处于轻量级状态

    - apply （官方推荐，异步处理，不用等待上一次提交的结果）
        异步提交，无返回值
        postWriteRunnable->awaitCommit.run()-> mcr.writtenToDiskLatch.await()（CountDownLatch原子操作）
        提交到内存commitToMemory()
        ->enqueueDiskWrite(mcr, postWriteRunnable)
        ->writeToDiskRunnable（writeToFile）
        ->QueuedWork.queue(writeToDiskRunnable, !isFromSyncCommit);
        ->final boolean isFromSyncCommit = (postWriteRunnable == null);
        ->!isFromSyncCommit   取反queue(writeToDiskRunnable,true)
        -> Handler handler = getHandler();
        -> if (shouldDelay && sCanDelay) {
              handler.sendEmptyMessageDelayed(QueuedWorkHandler.MSG_RUN, DELAY);
          } else {
              handler.sendEmptyMessage(QueuedWorkHandler.MSG_RUN);
          }
    - submit
        同步提交，有返回值
        提交到内存commitToMemory()-》enqueueDiskWrite(mcr, null)-》writeToDiskRunnable（writeToFile）
        ->QueuedWork.queue(writeToDiskRunnable, !isFromSyncCommit);
        ->同上不过QueuedWork.queue(writeToDiskRunnable, false);
    
## 注意点
    - 第一次获取sp对象，会全部读取到内存，尽量使用工作线程获取
    
## 原理
    - 
    
    
## 多进程
    context.getSharedPreferences("happy_shopping", Context.MODE_MULTI_PROCESS)
    
    MODE_MULTI_PROCESS参数已过时
    多进程间数据不能同步，建议使用ContentProvider