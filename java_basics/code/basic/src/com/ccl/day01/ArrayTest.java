package com.ccl.day01;

public class ArrayTest {
	
	public static void main(String[] args) {
		arryTest1();
		arryTest2();
		
	}
	/**
	 * 数组的复制、翻转、查找
	 */
	public static void arryTest1() {
		String[] arry = new String[] {"as","ac","ae","ba","bb","bc","cc","ce"};
		// 数组的复制
		// 1.自写的方法
		String[] arr1 = new String[arry.length];
		for(int i=0; i<arry.length;i++) {
			arr1[i] = arry[i];
		}
		// 2.Java提供的方法
//		String[] arr1 = arry.clone();
		
		// 数组的反转
		// 1.第一种方式
		String[] arr2 = arry.clone();
		for(int i=0;i<arr2.length/2;i++) {
			String temp = arr2[i];
			arr2[i] = arr2[arr2.length-i-1];
			arr2[arr2.length-i-1] = temp;
		}
		// 2.第二种方式，开辟新的数组
		String[] arr2_1 = new String[arr2.length];
		for(int i=arr2.length-1,j=0;i>=0;i--,j++) {
			arr2_1[j] = arr2[i];
		}
		
		// 3.第三种方式，使用java工具类java.util.Collections中的自带方法Collections.reverse()
		
		
		// 数组的查找（搜索）
		// 1.线性查找
		String dest = "ac";
		for(int i=0;i<arry.length;i++) {
//			if(arry[i] == dest) { // int类型使用 == 没有问题，字符串不建议使用
//				System.out.println("查找到目标，位置索引为："+i);
//				break;
//			}
			if(dest.equals(arry)) { // String类型拥有equals方法，用于判断两个字符串是否相等(相同)
				System.out.println("查找到目标，位置索引为："+i);
				break;
			}
		}
		
		// 2.二分查找,每次比较中间值，折半查找，要求被查询的数组要有序
		
		
		
	}
	
	/**
	 * 数组 冒泡排序、快速排序；看看视频中数组的讲解，有讲时间复杂度的推理，可以学习学习
	 */
	public static void arryTest2() {
		// 冒泡排序,相邻两个比较，依次
		int[] arr = new int[] {13,54,8,21,46,4};
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");	
		}
		
		
		// 快速排序
		
	}
	
	
	
}
