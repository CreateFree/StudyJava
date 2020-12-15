package com.ccl.exer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程方式三 实现 Callable接口
 *
 * @Auther: ccl
 * @Date: 2020/12/15 15:43
 * @Description:
 */
public class CallableTest {
    public static void main(String[] args) {
        // 3. 创建实现类的对象
        MyThread myThread = new MyThread();
        // 4. 创建FutureTask的对象，并将 实现类对象传进构造器中
        FutureTask futureTask = new FutureTask(myThread);
        // 5. 创建 Thread 对象实例，并将futureTask传进去，并调用Thread的start()方法
        new Thread(futureTask).start();

        // 6. 通过futureTask 对象调用 get()方法 获取 call() 方法的返回值
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



// 1. 创建 Callable的实现类
class MyThread implements Callable {

    // 2. 实现call() 方法（同Runnable中实现run()类似）
    @Override
    public Object call() throws Exception {
        int sum =0;
        for (int i = 1; i < 100; i++) {
            if(i %2 == 0){
                sum += i;
            }
        }
        // 注意这里 返回的是Integer对象，这里自动封箱了
        return sum;
    }
}