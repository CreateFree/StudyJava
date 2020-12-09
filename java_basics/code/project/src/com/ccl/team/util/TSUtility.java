/**  
* @文件名 TSUtility.java
* @版权 Copyright 2009-2020 
* @描述 TSUtility.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午8:56:11
* @修改内容 新增
*/
package com.ccl.team.util;

import java.util.Scanner;

/**
 * 
 * @Description 工具类，用于键盘输入
 * @aothor chencl
 * @date 2020年12月9日上午8:56:11
 */
public class TSUtility {

	/**
	 * @Fields scanner : 私有Scanner实例化对象
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @Description 读取键盘输入值，如果用户输入'1'-'4'中的字符，则方法返回。
	 * @author chencl
	 * @date 2020年12月9日 上午9:01:20
	 * @return 用户输入的值
	 */
	public static char readMenuSelection() {
		char c;
		// 持续监听用户命令行输入
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.print("输入错误，请重新选择(1-4)：");
			} else
				break;
		}
		return c;
	}
	
	/**
	 * 
	 * @Description 提示并等待，直到用户输入回车键后返回
	 * @author chencl
	 * @date 2020年12月9日 上午9:26:03
	 */ 
	public static void readReturn() {
		System.out.print("按回车键继续...");
		readKeyBoard(100, true);
	}
	
	/**
	 * 
	 * @Description 从键盘读取一个不超过2位的整数，并将其作为方法返回值
	 * @author chencl
	 * @date 2020年12月9日 上午9:28:09
	 * @return 输入的整数
	 */ 
	public static int readInt() {
		int n;
		for(; ;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("数字错误，请重新输入：");
			}
		}
		return n;
	}
	
	/**
	 * 
	 * @Description 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
	 * @author chencl
	 * @date 2020年12月9日 上午9:30:38
	 * @return
	 */ 
	public static char readConfirmSelection() {
		char c;
		for(; ;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);			
			if(c == 'Y' || c== 'N') {
				break;
			}else {
				System.out.print("选择错误，请重新输入(Y/N)：");
			}
		}
		return c;
	}
	
	/**
	 * 
	 * @Descriptioin 提取出的读取键盘输入方法
	 * @author chencl
	 * @date 2020年12月9日 上午9:04:30
	 * @param i 输入值的长度限制（字符长度）
	 * @param b 是否返回空字符串
	 * @return 符合输入限制要求的值
	 */
	private static String readKeyBoard(int i, boolean b) {
		String line = "";

		// scanner.hasNextLine() : 当且仅当此scanner输入另一行此方法返回true
		// 也就是说使用while循环来判断scanner输入回车后结束读取输入
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (b)
					return line;
				else
					continue;
			}

			if (line.length() < 1 || line.length() > i) {
				System.out.print("输入长度（不大于" + i + ")错误，请重新输入：");
				continue;
			}
			break;
		}

		return line;
	}
}
