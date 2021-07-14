## 启动优化
- 启动黑白屏（必须）

- 查看启动时间
>**命令：**
> adb shell am start -S -W com.go.shopping/.SplashActivity
>**输出参数：**
>WaitTime：包括前一个应用Activity pause的时间和新应用启动的时间；
 ThisTime：表示一连串启动Activity的最后一个Activity的启动耗时；
 TotalTime：表示新应用启动的耗时，包括新进程的启动和Activity的启动，但不包括前一个应用Activity pause的耗时。

- 记得使用 CPU profiler
    - 懒加载or异步加载
    - 检查布局层级
    - 主线程耗时操作（I/O为主）
    - 
- 开启严格模式检查-代码开启StrictMode类
- 开发者模式选项
    - 调试GPU过度绘制
    - 严格模式-主线程
    - 显示布局边界
    
- IdleHandler延迟加载

>说明：当系统进入空闲时才会执行，从而达到延迟加载，源码源码源码
```
Looper.myQueue().addIdleHandler(new IdleHandler() {  
    @Override  
    public boolean queueIdle() {  
        //你要处理的事情
        return false; //false表示只执行一次，true表示下次空闲还会执行   
    }  
});
```

- 类加载优化: 提前异步类加载
    - Class.forName()只加载类本身及其静态变量的引用类
    - new 类实例可以额外加载类成员变量的引用类
    
    
    
    
    
    
    
    
    
```
①点击桌面App图标，Launcher进程采用Binder IPC向system_server进程发起startActivity请求；

②system_server进程接收到请求后，向zygote进程发送创建进程的请求；

③Zygote进程fork出新的子进程，即App进程；

④App进程，通过Binder IPC向sytem_server进程发起attachApplication请求；

⑤system_server进程在收到请求后，进行一系列准备工作后，再通过binder IPC向App进程发送scheduleLaunchActivity请求；

⑥App进程的binder线程（ApplicationThread）在收到请求后，通过handler向主线程发送LAUNCH_ACTIVITY消息；

⑦主线程在收到Message后，通过反射机制创建目标Activity，并回调Activity.onCreate()等方法。

⑧到此，App便正式启动，开始进入Activity生命周期，执行完onCreate/onStart/onResume方法，UI渲染结束后便可以看到App的主界面。

```