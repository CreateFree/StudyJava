/**  
* @文件名 NameListService.java
* @版权 Copyright 2009-2020 
* @描述 NameListService.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午10:13:46
* @修改内容 新增
*/
package com.ccl.team.service;

import com.ccl.team.domain.Architect;
import com.ccl.team.domain.Designer;
import com.ccl.team.domain.Employee;
import com.ccl.team.domain.Equipment;
import com.ccl.team.domain.NoteBook;
import com.ccl.team.domain.PC;
import com.ccl.team.domain.Printer;
import com.ccl.team.domain.Programmer;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午10:13:46
 */
public class NameListService {
	
	/**
	 * @Fields employees : 用来保存公司所有员工对象
	 */ 
	private Employee[] employees;
	
	/**
	 *
	 *根据项目提供的Data类构建相应大小的employees数组
	 *再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
	 *将对象存于数组中
	 */
	public NameListService() {
		
		employees = new Employee[Data.EMPLOYEES.length];
		for(int i=0; i<Data.EMPLOYEES.length; i++) {
			
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			Equipment equipment = getEquipmentByIndex(i);
			
			if(Data.EMPLOYEES[i][0] == (""+Data.ARCHITECT) ){				
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);									
				employees[i] = new Architect(id, name, age, salary,  equipment, bonus, stock);
			}else if(Data.EMPLOYEES[i][0] == (""+Data.PROGRAMMER)) {
				employees[i] = new Programmer(id, name, age, salary, equipment);
			}else if(Data.EMPLOYEES[i][0] == (""+Data.DESIGNER)) {
				double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
			}else if(Data.EMPLOYEES[i][0] == (""+Data.EMPLOYEE)) {				
				employees[i] = new Employee(id, name, age, salary);
			}
		}
	}
	
	private Equipment getEquipmentByIndex(int i) {
		Equipment equipment = null;
		String model;
		if(Data.EQUIPMENTS[i].length == 0) {
			return equipment;
		}
		switch(Integer.parseInt(Data.EQUIPMENTS[i][0])) {
		case Data.PC: 
			model = Data.EQUIPMENTS[i][1];
			String display = Data.EQUIPMENTS[i][2];
			equipment = new PC(model, display);
			break;
		case Data.NOTEBOOK: 
			model = Data.EQUIPMENTS[i][1];
			double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
			equipment = new NoteBook(model, price);
		case Data.PRINTER:
			String printerName = Data.EQUIPMENTS[i][1];
			String type = Data.EQUIPMENTS[i][2];
			equipment = new Printer(printerName, type);
		}
		return equipment;
	}
	/**
	 * 
	 * @Description 获取所有员工实体
	 * @author chencl
	 * @date 2020年12月9日 上午10:18:18
	 * @return
	 */ 
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * @Description 根据ID获取员工实体
	 * @author chencl
	 * @date 2020年12月9日 上午10:18:20
	 * @param id
	 * @return
	 */ 
	public Employee getEmployee(int id) throws TeamException{
		Employee employee = null;
		for(int i = 0; i<employees.length; i++) {
			if(employees[i].getId() == id) {
				employee = employees[i];
				break;
			}
		}
		return employee;
	}
	
	public static void main(String[] args) {
		NameListService nameListService = new NameListService();
		
		Employee[] employeeArr = nameListService.getAllEmployees();
		for(int i = 0; i<employeeArr.length; i++) {
			Employee e = employeeArr[i];
			System.out.println(e.getId()+"  name:"+e.getName()+"  age:"+e.getAge());
		}
		System.out.println("***************************************************");
		
		Employee p = null;
		try {
			p = nameListService.getEmployee(2);
		} catch (TeamException e) {
			e.printStackTrace();
		}
		System.out.println("ID为2的员工： "+p.getId()+"  name:"+p.getName()+"  age:"+p.getAge());
	}
}
