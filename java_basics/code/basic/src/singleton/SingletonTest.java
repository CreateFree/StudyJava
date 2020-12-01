/**  
* @文件名 SingletonTest.java
* @版权 Copyright 2009-2020 
* @描述 SingletonTest.java
* @修改人 chencl
* @修改时间 2020年12月1日 下午4:09:30
* @修改内容 新增
*/
package singleton;

/**
 *  单例设计模式
 *  1.所谓类的单例设计模式，指的就是采取一定方法保证整个软件系统中，对某个类只能存在一个对象实例
 *  
 *  2.如何实现
 *      饿汉式
 *      懒汉式
 *      
 *  3.区别饿汉式和懒汉式
 *  	饿汉式：
 *  		好处：线程是安全的
 *  		坏处：对象加载时间过长
 *  	懒汉式：
 *  		好处：延迟对象的加载
 *  		坏处：多线程时需要修改一下
 *  
 * @aothor chencl
 * @date 2020年12月1日下午4:09:30
 */
public class SingletonTest {
	
	public static void main(String[] args) {
		Bank b1 = Bank.getInstance();
		Bank b2 = Bank.getInstance();
		System.out.println(b1 == b2);
		
		System.out.println("************");
		Order o1 = Order.getInstance();
		Order o2 = Order.getInstance();
		System.out.println(o1 == o2);
	}
}

// 饿汉式
class Bank{
	// 1. 私有化构造器
	private Bank() {
		
	}
	
	// 2. 内部创建类的对象
	// 4. 由于返回的方法是静态的，所以方法中涉及到的属性也是静态的
	private static Bank instance = new Bank();
	
	// 3. 提供公共的静态的方法返回当前类的对象实例
	public static Bank getInstance() {
		return instance;
	}	
	
}


// 懒汉式
class Order{
	private Order() {
		
	}
	// 同饿汉式的写法上的区别
	private static Order instance = null;
	
	public static Order getInstance() {
		if(instance == null) {
			instance = new Order();
		}
		return instance;
	}
}
