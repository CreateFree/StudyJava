/**  
* @文件名 InstanceofTest.java
* @版权 Copyright 2009-2020 
* @描述 InstanceofTest.java
* @修改人 chencl
* @修改时间 2020年11月30日 上午9:43:44
* @修改内容 新增
*/
package com.ccl.instanceoftest;

/**
 * 
 * @aothor chencl
 * @date 2020年11月30日上午9:43:44
 */
public class InstanceofTest {
	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		
		System.out.println(b instanceof A);
		System.out.println("***************");
		System.out.println(a instanceof B);
		System.out.println("***************");
		System.out.println(a instanceof Object);
		
	}
}


class A {
	int i = 10;
	
	/**
	 * 
	 * @author chencl
	 * @date 2020年11月30日 上午9:44:19
	 */
	public int add(int i) {
		return this.i+i;
	}
}

class B extends A{
	int a = 5;
}