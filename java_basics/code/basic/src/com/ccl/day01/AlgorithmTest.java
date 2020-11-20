package com.ccl.day01;

import java.util.Scanner;

public class AlgorithmTest {

	public static void main(String[] args) {
		multiplicationTable();
		//arrayMax();
		//getEven();
		//isPrimeNumber();
		//printScore();
		accumulation();
		yangHuiTest();
	}

	private static void multiplicationTable() {
		for(int i=1; i<10; i++) {
			for(int j=1; j<=i;j++) {
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 定义一个二维数组，int类型，int[2][4]，要求输入8个整数，存入到数组中，然后输出最大的值
	 */
	public static void arrayMax(){
		Scanner scanner = new Scanner(System.in);
		int[][] array = new int[2][4];
		for(int i=0;i<array.length;i++){
			for(int j=0; j< 4;j++){
				System.out.print("请输入"+ i + "行" + j + "列数字");
				array[i][j] = scanner.nextInt();
			}
		}
		int max = array[0][0];
		for(int i=0; i<array.length; i++){
			for(int j=0; j< 4;j++){
				if(array[i][j] > max){
					max = array[i][j];
				}
			}
		}
		System.out.println("最大值是"+max);
	}
	
	/**
	 *定义一个长度为10的整型数组，循环输入10个整数。然后判断这个数组中有几个偶数，
	 *再定义一个正好能存放这几个偶数的数组，将上一个数组中的所有偶数复制过来。
	 *最后循环输出这些偶数。
	 */
	public static void getEven(){
		Scanner scanner = new Scanner(System.in);
		int[] array = new int[10];
		int evenNum = 0;
		for(int i=0; i<10; i++){
			System.out.println("请输入第"+ (i+1) +"个数");
			array[i] = scanner.nextInt();
			if(array[i] % 2 ==0){
				evenNum++;
			}
		}
		int[] evenArray = new int[evenNum];
		evenNum = 0;
		for(int j =0; j< array.length; j++){
			if(array[j] % 2 == 0){
				evenArray[evenNum] = array[j];
				evenNum++;
			}
		}
		System.out.println("数组中共用偶数"+ evenNum+"个。");
		System.out.println("分别是：");
		for(int n =0; n<evenNum; n++){
			System.out.print(evenArray[n]+" ");
		}
		System.out.println();
	}
	
	/**
	 * 判断一个数是否是质数（只能被1和本身整除的数叫质数）
	 */
	public static void isPrimeNumber(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int num = scanner.nextInt();
		boolean flag = true;
		for(int i=2; (i*i) < (num+1); i++){
			if(num%i == 0){
				flag = false;
			}
		}
		if(flag){
			System.out.println(num+"这个数是质数！");
		}else{
			System.out.println(num+"这个数不是质数！");
		}
	}
	
	/**
	 * 定义一个二维数组，用来记录3个学生的java,c#,sql三门功课的成绩，
	 * 二维数组的一行记录一个人的成绩
	 */
	public static void printScore(){
		int[][] array = new int [3][3];
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i< 3; i++){
			System.out.println("请输入第"+ (i+1) + "个学生的Java成绩：");
			array[i][0] = scanner.nextInt();
			System.out.println("请输入第"+ (i+1) + "个学生的C#成绩：");
			array[i][1] = scanner.nextInt();
			System.out.println("请输入第"+ (i+1) + "个学生的SQL成绩：");
			array[i][2] = scanner.nextInt();			
		}
		System.out.println("\t       Java C# SQL");
		for(int j=0; j< 3; j++){
			System.out.println("第"+(j+1)+"名学生成绩： "+ array[j][0] +" "+ array[j][1]+" "+ array[j][2]);
		}
	}
	
	/**
	 * 计算1+1/2+1/3+1/4+1/5+1/6+1/7+1/8+1/9+1/10=?
	 */
	public static void accumulation(){
		double sum = 1;
		for(int i=2;i<=10;i++){
			sum = sum + (double)1/i;
		}
		System.out.println(sum);
	}
	
	/**
	 * 从1不断的累加，最多加到100，但如果你的累加结果正好大于1000时，要求也结束这个循环。
	 * 问这个时候正好加到了几？
	 */
	public static void accumulation2(){
		int sum =0;
		for(int i=1; i<=100; i++){
			sum += i;
			if(sum >1000){
				System.out.println("这个时候正好加到了 "+ i);
				break;
			}
		}
	}
	
	/**
	 * 从1累加到100，但如果要累加的数据能被3整除，并且也能被7整数，那么就不要累加这个数。
	 * 最后输出结果。
	 */
	public static void accumulation3(){
		int sum = 0;
		for(int i=1; i<=100; i++){
			if(i%3 == 0 && i%7 == 0){
				continue;
			}else{
				sum += i;
			}
		}
		System.out.println("结果："+ sum);
	}
	
	/**
     * 打印图形
     * *
     * ***
     * *****
     * *******
     * *********
     * ***********
     * *************
     */
	public static void printGeometry(){
		for(int i=0; i<7; i++){
			int printCount = i+2*i;
			for(int j=0;j<printCount;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * 杨辉三角测试，打印10行
	 */
	private static void yangHuiTest() {
		int[][] arry = new int[10][];
		for(int i=0;i<arry.length;i++) {
			arry[i] = new int[i+1];
			arry[i][0] = 1;
			arry[i][i] = 1;
			
			for(int j=1;j<i;j++) {
				arry[i][j] = arry[i-1][j-1]+arry[i-1][j];
			}
		}
		
		for(int i=0; i<arry.length;i++) {
			for(int j=0;j<arry[i].length;j++) {
				System.out.print(arry[i][j]+"  ");
			}
			System.out.println();
		}
	}
}
