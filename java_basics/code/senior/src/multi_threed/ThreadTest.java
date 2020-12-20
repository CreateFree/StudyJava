package multi_threed;


import org.junit.Test;

/**
 * @Auther: ccl
 * @Date: 2020/12/14 15:39
 * @Description:
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程方式一
        // 3.创建Thread或Thread子类的实例对象
        MyThread1 myThread1 = new MyThread1();
        // 4.调用 start() 方法
        myThread1.start();

        // 创建线程方式二
        MyThread2 myThread2 = new MyThread2();
        // 还是需要创建Thread实例对象，只是使用带有Runnable的构造器
        Thread thread = new Thread(myThread2);
        thread.start();

        // 匿名写法要认得到
        // 比如使用匿名的线程：
        new Thread(){
            @Override
            public void run() {
                // TO-DO
            }
        }.start();
        // 还有这种
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}

// 创建线程的方式一：继承 Thread
// 1.继承Thread
class MyThread1 extends Thread{
    // 2.重写run() 方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2 ==0){
                // System.out.println(Thread.currentThread().getName()+":"+i);
                System.out.println(getName()+":"+i);
            }
        }
    }
}

// 创建线程方式二：实现 Runnable接口
class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                // 这个只能用Thread.currentThread().getName，因为不是继承
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

// 线程的常用方法 getName() sleep() jion() yeild() wait() notify()/notifily() ...

/***********************************************************************/

// 线程的生命周期
// 新建、就绪、运行、阻塞、死亡

class Thread1 implements Runnable{

    @Override
    public void run() {
        // try {
        //     Thread.sleep(100);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println("此时线程1运行结束，准备死亡");
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        // try {
        //     Thread.sleep(10);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        for (int i = 10; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println("此时线程2运行结束，准备死亡");
    }
}


class ThreadLiveTest{

    // 线程的生命周期测试
    @Test
    public void ThreadLiveTest(){

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        System.out.println("此时创建了两个线程t1、t2");

        // 调用了start后，两个线程就进入了就绪阶段，但是此时t1可能并没有获得CPU执行权，
        // 所以可能输出的时候显示的是t2的开始
        t1.start();
        // t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/***********************************************************************/
