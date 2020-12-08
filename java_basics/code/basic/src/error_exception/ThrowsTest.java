/**  
* @文件名 ThrowsTest.java
* @版权 Copyright 2009-2020 
* @描述 ThrowsTest.java
* @修改人 chencl
* @修改时间 2020年12月8日 下午4:57:32
* @修改内容 新增
*/
package error_exception;

import org.junit.Test;

/**
 * 
 * @aothor chencl
 * @date 2020年12月8日下午4:57:32
 */
public class ThrowsTest {

	@Test
   public void test() throws ArrayIndexOutOfBoundsException{
		String[] str = new String[1]; 
		// ①
		System.out.println(str[2]);
		// ②
		System.out.println("报错！");
	}
}
