/**  
* @文件名 MainTest.java
* @版权 Copyright 2009-2020 
* @描述 MainTest.java
* @修改人 chencl
* @修改时间 2020年12月1日 上午10:22:49
* @修改内容 新增
*/
package junit_test;

/**
 * 
 * @aothor chencl
 * @date 2020年12月1日上午10:22:49
 */
public class MainTest {
//	public static void main(String[] args) {
//		String a1 = args[1];
//		String a2 = args[2];
//		String a3 = args[3];
//		System.out.println(a3);
//	}
}


interface Inter {
	void show(int a, int b);

	void func();
}

class Demo {
	public static void main(String[] args) {
		// 补足代码；调用两个函数，要求用匿名内部类
		Inter in = new Inter() {
			public void show(int a, int b) {
				
			}

			public void func() {
				
			}
		};

		in.show(4, 5);
		in.func();

	}
}
