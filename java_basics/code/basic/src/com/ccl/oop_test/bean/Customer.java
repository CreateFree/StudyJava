package com.ccl.oop_test.bean;

/**
 * 
 * @Title: Customer
 * @Description: Customer实体类
 * @aothor chencl
 * @date 2020年11月25日下午5:18:18
 */
public class Customer {
	// 用户姓名
	private String name;
	// 用户
	private char gender;
	// 用户年龄
	private int age;
	// 电话
	private String phone;
	// 邮箱
	private String email;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 *
	 * Description: 
	 */
	public Customer() {
	}
	/**
	 *
	 * Description: 
	 * @param name
	 * @param gender
	 * @param age
	 * @param phone
	 * @param email
	 */
	public Customer(String name, char gender, int age, String phone, String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	

}
