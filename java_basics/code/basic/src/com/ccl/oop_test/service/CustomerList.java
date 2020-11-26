package com.ccl.oop_test.service;

import com.ccl.oop_test.bean.Customer;

/**
 * 
 * Title: CustomerList
 * Description: 用于处理业务逻辑
 * @aothor chencl
 * @date 2020年11月25日下午5:17:53
 */
public class CustomerList {
	/**
	 * @Fields customer :用于存放用户对象的数组 
	 */ 
	private Customer[] customers;
	/**
	 * @Fields total :记录已保存客户对象的数量
	 */ 
	private int total = 0;

	/**
	 *
	 * Description: 构造器，用来初始化customers数组
	 * @param total 指定customers数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	} 
	
	/**
	 * 
	 * @Title addCustomer
	 * @author chencl
	 * @Description: 将参数customer添加到数组中最后一个客户对象记录之后
	 * @date 2020年11月26日 上午10:53:31
	 * @param customer 指定要添加的客户对象
	 * @return true:添加成功；false：添加失败。
	 */ 
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total] = customer;
		total++;
		return true;
	}
	
	/**
	 * 
	 * @Title replaceCustomer
	 * @author chencl
	 * @Description: 用参数customer替换数组中由index指定的对象
	 * @date 2020年11月26日 上午10:52:11
	 * @param index 指定所替换对象在数组中的位置，从0开始
	 * @param cust 指定替换的新客户对象
	 * @return 替换成功返回true；false表示索引无效，无法替换
	 */ 
	public boolean replaceCustomer(int index, Customer cust) {
		if(index<0 || index>=total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	/**
	 * 
	 * @author chencl
	 * @Description: 从数组中删除参数index指定索引位置的客户对象记录
	 * @date 2020年11月26日 上午10:52:15
	 * @param index 指定所删除对象在数组中的索引位置，从0开始
	 * @return 删除成功返回true；false表示索引无效，无法删除
	 */ 
	public boolean deleteCustomer(int index) {
		if(index<0 || index>= total) {
			return false;
		}
		for (int i = index; i < customers.length-1; i++) {
			customers[i] = customers[i+1];
		}
//		customers[total-1] = null;
//		total = total-1;
		customers[--total] = null;
		return true;
	}
	/**
	 * 
	 * @author chencl
	 * @Description: 返回数组中记录的所有客户对象
	 * @date 2020年11月26日 上午10:52:18
	 * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
	 */ 
	public Customer[] getAllCustomers() {
//		return customers; 这种将后面所有的空都返回了，不好
		Customer[] custs = new Customer[total];
		for (int i = 0; i < total; i++) {
			custs[i] = customers[i];			
		}
		return custs;
	}
	/**
	 * 
	 * @author chencl
	 * @Description: 返回参数index指定索引位置的客户对象记录
	 * @date 2020年11月26日 上午10:52:21
	 * @param index 指定所要获取的客户在数组中的索引位置，从0开始
	 * @return 封装了客户信息的Customer对象，没有找到返回null
	 */ 
	public Customer getCustomer(int index) {
		if(index <0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * 
	 * @author chencl
	 * @Description: 获取用户总数
	 * @date 2020年11月26日 上午10:52:23
	 * @return
	 */ 
	public int getTotal() {
		return total;
	}


}
