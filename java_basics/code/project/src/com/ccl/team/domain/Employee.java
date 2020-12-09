/**  
* @文件名 Employee.java
* @版权 Copyright 2009-2020 
* @描述 Employee.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午9:41:19
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午9:41:19
 */
public class Employee {
	private int id;
	private String name;
	private int age;
	private double salary;

	/**
	 *
	 */
	public Employee() {
		super();
	}

	/**
	 *
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	protected String getDetails() {
		return id + "\t" + name + "\t" + age + "\t" + salary;
	}

	@Override
	public String toString() {
		return getDetails();
	}
	
	 

}
