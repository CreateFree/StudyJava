package multi_threed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * 创建线程的方式四 —— 使用线程池
 *
 * @Auther: ccl
 * @Date: 2020/12/15 15:59
 * @Description:
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1. 创建指定数量的线程池
        // 借助的是Executors，但是对这个还不清楚，先记住。关于这个可以看API
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 这一步，是因为ThreadPoolExecutor 继承与 ExecutorService 接口的实现类，因此 service 可以向下转型
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 2. 执行指定线程。execute \ submit
        service1.execute(new PoolTestThread1()); // execute 适用于 Runnable接口
        service1.execute(new PoolTestThread2());

        // service1.submit(); // 适用于 Callable接口

        // 3. 关闭线程池
        service1.shutdown();
    }
}


class PoolTestThread1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 线程1");
    }
}

class PoolTestThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 线程2");
    }
}