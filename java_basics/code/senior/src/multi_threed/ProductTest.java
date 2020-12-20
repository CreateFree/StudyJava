package multi_threed;

/**
 * 线程通信 经典例题：生产者/消费者问题
 * <p>
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1.是否是多线程问题？ 是，生产者线程，消费者线程。
 * 2.是否有线程安全问题？ 是，有共享数据-店员（产品）
 * 3.如何解决多线程安全问题？ 同步机制
 * 4.是否涉及到线程的通信？ 是
 *
 * @Auther: ccl
 * @Date: 2020/12/14 21:01
 * @Description:
 */
public class ProductTest {
    public static void main(String[] args) {

    }
}

class Clerk {

    private int productCount =0;
    /**
     * 产品被生产者生产
     */
    public void produceProduct() {
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ": 生产第"+ productCount +"个产品");
        }else{
            // 等待
        }
    }

    /**
     * 产品被取走
     */
    public void consumeProduct() {
        if(productCount >0){
            System.out.println(Thread.currentThread().getName() + ": 取走第"+ productCount +"个产品");
            productCount--;
        }else {
            //
        }
    }
}

class Productor extends Thread {
    private Clerk clerk;

    @Override
    public void run() {
        System.out.println(getName()+": 开始生产产品……");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Customer extends Thread {
    private Clerk clerk;

    @Override
    public void run() {
        System.out.println(getName() + "：消费产品……");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
