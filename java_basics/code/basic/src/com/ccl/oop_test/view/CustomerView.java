
package com.ccl.oop_test.view;

import com.ccl.oop_test.bean.Customer;
import com.ccl.oop_test.service.CustomerList;
import com.ccl.oop_test.util.CustomerUtility;

/**
 * 
 * @Title: CustomerView
 * @Description:
 * @aothor chencl
 * @date 2020年11月25日下午5:13:20
 */
public class CustomerView {
	// 构造能够存储10个用户的CustomerList实例
	private CustomerList customerList = new CustomerList(10);

	public CustomerView() {
		Customer customer = new Customer("张三", '男', 7, "12332145678", "325413@fda.com");
		customerList.addCustomer(customer);
	}
	/**
	 * 
	 * @Description: 显示主菜单，响应用户输入，根据用户操作分别调用其他相应的成员方法，以完成客户信息处理。
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:25
	 */
	public void enterMainMenu() {
		boolean flag = true;
		while(flag) {
			System.out.println("\n----------------------------客户信息管理软件----------------------------");
			System.out.println("                                            1添加客户");
			System.out.println("                                            2修改客户");
			System.out.println("                                            3删除客户");
			System.out.println("                                            4客户列表");
			System.out.println("                                            5退    出\n");
			System.out.print("   请选择(1-5)操作：");
			char menu = CustomerUtility.readMenuSelection();
			switch (menu) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':				
				System.out.print("确实是否退出(Y/N)：");
				char isOut = CustomerUtility.readConfirmSelection();
				if(isOut == 'Y') {
					flag = false;	
				}
				break;
			}			
		}
		
	}

	/**
	 * 
	 * @Description: 添加用户操作
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:28
	 */
	private void addNewCustomer() {
		System.out.println("----------------------------添加用户操作----------------------------");
		System.out.print("姓名：");
		String name = CustomerUtility.readString(10);
		System.out.print("性别：");
		char gender = CustomerUtility.readChar();
		System.out.print("年龄：");
		int age = CustomerUtility.readInt();
		System.out.print("电话：");
		String phone = CustomerUtility.readString(13);
		System.out.print("邮箱：");
		String email = CustomerUtility.readString(15);
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean flag = customerList.addCustomer(cust);
		if(flag == true) {
			System.out.println("----------------------------添加成功！----------------------------");
		}else {
			System.out.println("-------------------- 添加失败！请重试----------------------------");
		}
		
	}

	/**
	 * 
	 * @Description: 修改用户操作
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:31
	 */
	private void modifyCustomer() {
		System.out.println("----------------------------修改用户操作----------------------------");
		System.out.print("请选择修改对象编号(-1退出)：");
		int index = CustomerUtility.readInt();
		if(index == -1) {
			return;
		}else if(index<=0 || index>customerList.getTotal()) {
			System.out.println("-----------------未找到目标对象，请重试---------------------");
			modifyCustomer();
			return;
		}else {
			Customer customer = customerList.getCustomer(--index);
			// 输出当期用户带默认值
			System.out.print("姓名("+customer.getName()+")：");
			String name = CustomerUtility.readString(10, customer.getName());
			customer.setName(name);
			System.out.print("性别("+customer.getGender()+")：");
			char gender = CustomerUtility.readChar(customer.getGender());
			customer.setGender(gender);
			System.out.print("年龄("+customer.getAge()+")：");
			int age = CustomerUtility.readInt(customer.getAge());
			customer.setAge(age);
			System.out.print("电话("+customer.getPhone()+")：");
			String phone = CustomerUtility.readString(13,customer.getPhone());
			customer.setPhone(phone);
			System.out.print("邮箱("+customer.getEmail()+")：");
			String email = CustomerUtility.readString(15,customer.getEmail());
			customer.setEmail(email);
			
			boolean flag = customerList.replaceCustomer(index, customer);
			if(flag == true) {
				System.out.println("----------------------------修改成功！----------------------------");
			}else {
				System.out.println("---------------------修改失败！请重试----------------------------");
			}
		}
	}

	/**
	 * 
	 * @Description: 删除用户操作
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:33
	 */
	private void deleteCustomer() {
		System.out.println("----------------------------删除用户操作----------------------------");
		System.out.print("请选择删除对象编号(-1退出)：");
		int index = CustomerUtility.readInt();
		if(index == -1) {
			return;
		}else if(index<=0 || index>customerList.getTotal()) {
			System.out.println("-----------------未找到目标对象，请重试---------------------");
			deleteCustomer();
			return;
		}else {
			System.out.print("确实是否删除(Y/N)：");
			char isOut = CustomerUtility.readConfirmSelection();
			if(isOut == 'Y') {
				boolean flag = customerList.deleteCustomer(index-1);
				if(flag == true) {
					System.out.println("----------------------------删除成功！----------------------------");
				}else {
					System.out.println("--------------------------删除失败！请重试---------------------------");
					deleteCustomer();
				}
			}			
		}
	}

	/**
	 * 
	 * @Description: 查询用户操作
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:36
	 */
	private void listAllCustomers() {
		System.out.println("\n----------------------------客户列表----------------------------");
		int total = customerList.getTotal();
		if(total == 0 ) {
			System.out.println("没有找到客户记录！");
		}else {
			System.out.println("编号 姓名\t性别\t年龄 电话\t\t邮箱");
			Customer[] custs = customerList.getAllCustomers();
			for (int i = 0; i < custs.length; i++) {
				System.out.println((i+1)+"\t"+custs[i].getName()+"\t"+custs[i].getGender()+"\t"+custs[i].getAge()+"\t"+custs[i].getPhone()+"\t\t"+custs[i].getEmail());
			}
		}		
		System.out.println("\n-------------------------客户列表加载完成-------------------------");
	}

	/**
	 * 
	 * @Description: 主方法，程序入口
	 * @author chencl
	 * @date 2020年11月26日 上午11:20:38
	 * @param args
	 */
	public static void main(String[] args) {
		CustomerView customerView = new CustomerView();
		customerView.enterMainMenu();
	}
}
