/**  
* @文件名 ExceptionTest.java
* @版权 Copyright 2009-2020 
* @描述 ExceptionTest.java
* @修改人 chencl
* @修改时间 2020年12月8日 下午3:42:02
* @修改内容 新增
*/
package error_exception;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*
 * 
 * 异常体系结构
 * 
 * java.lang.Throwable
 * 		|-----java.lang.Error:一般不编写针对性的代码进行处理。
 * 		|-----java.lang.Exception:可以进行异常的处理
 * 			|------编译时异常(checked)
 * 					|-----IOException
 * 						|-----FileNotFoundException
 * 					|-----ClassNotFoundException
 * 			|------运行时异常(unchecked,RuntimeException)
 * 					|-----NullPointerException
 * 					|-----ArrayIndexOutOfBoundsException
 * 					|-----ClassCastException
 * 					|-----NumberFormatException
 * 					|-----InputMismatchException
 * 					|-----ArithmeticException
 * 
 * 
 */

/**
 * 常见异常
 * 
 * @aothor chencl
 * @date 2020年12月8日下午3:42:02
 */
public class ExceptionTest {

	// NullPointerException
	@Test
	public void test1() {
		int[] arr = null;
		System.out.println(arr[3]);

	}

	// ArithmeticException
	@Test
	public void test6() {
		int a = 10;
		int b = 0;
		System.out.println(a / b);
	}

	// InputMismatchException
	@Test
	public void test5() {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		System.out.println(score);
		scanner.close();
	}

	// NumberFormatException
	@Test
	public void test4() {
		String str = "123";
		str = "abc";
		int num = Integer.parseInt(str);
	}

	// ClassCastException
	@Test
	public void test3() {
		Object obj = new Date();
		String str = (String) obj;
	}

	// IndexOutOfBoundsException
	@Test
	public void test2() {
		// ArrayIndexOutOfBoundsException
//			int[] arr = new int[10];
//			System.out.println(arr[10]);
		// StringIndexOutOfBoundsException
		String str = "abc";
		System.out.println(str.charAt(3));
	}

	/*
	 * 
	 * 异常处理，抓抛模型
	 * 
	 * 过程一，“抛”：程序在正常执行过程中，一旦出现异常，就会在异常代码生成一个对应异常类的对象。 并将此对象抛出。 一旦抛出对象后，后续代码不在执行。
	 * 
	 * 过程二，“抓”：可以理解为处理异常的方式：①try-catch-finally，②throws
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void test() {

	}
}
