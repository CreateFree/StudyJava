/**  
* @文件名 TeamView.java
* @版权 Copyright 2009-2020 
* @描述 TeamView.java
* @修改人 chencl
* @修改时间 2020年12月9日 下午12:56:04
* @修改内容 新增
*/
package com.ccl.team.view;

import com.ccl.team.domain.Employee;
import com.ccl.team.domain.Programmer;
import com.ccl.team.service.NameListService;
import com.ccl.team.service.TeamException;
import com.ccl.team.service.TeamService;
import com.ccl.team.util.TSUtility;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日下午12:56:04
 */
public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * 
	 * @Description 主界面显示及控制方法
	 * @author chencl
	 * @date 2020年12月9日 下午12:59:57
	 */
	public void enterMainMenu() {
		boolean loopFlag = true;
		char key = 0;

		do {
			if (key != '1') {
				listAllEmployees();
			}
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			key = TSUtility.readMenuSelection();
			System.out.println();
			switch (key) {
			case '1':
				listTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char yn = TSUtility.readConfirmSelection();
				if (yn == 'Y') {
					loopFlag = false;
				}
				break;
			}
		} while (loopFlag);
	}

	/**
	 * 
	 * @Description 以表格形式列出公司所有成员
	 * @author chencl
	 * @date 2020年12月9日 下午1:00:14
	 */
	private void listAllEmployees() {
		System.out.println("\n----------------------------------------开发团队调度软件---------------------------------");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees.length == 0) {
			System.out.println("没有团队成员记录！");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		}

		for (Employee e : employees) {
			System.out.println(" " + e);
		}
		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * 
	 * @Description 显示团队成员列表操作
	 * @author chencl
	 * @date 2020年12月9日 下午1:00:19
	 */
	private void listTeam() {
		System.out.println("\n--------------------团队成员列表---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team.length == 0) {
			System.out.println("开发团队目前没有成员！");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		}

		for (Programmer p : team) {
			System.out.println(" " + p.getDetailsForTeam());
		}
		System.out.println("-----------------------------------------------------");
	}

	/**
	 * 
	 * @Description 实现添加成员操作
	 * @author chencl
	 * @date 2020年12月9日 下午1:00:27
	 */
	private void addMember() {
		System.out.println("-----------------------添加成员-----------------------");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();

		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}

		TSUtility.readReturn();
	}

	/**
	 * 
	 * @Description 实现删除成员操作
	 * @author chencl
	 * @date 2020年12月9日 下午1:00:33
	 */
	private void deleteMember() {
		System.out.println("-----------------------删除成员-----------------------");
		System.out.print("请输入要删除的员工TID：");
		int id = TSUtility.readInt();

		System.out.print("确认是否删除(Y/N)：");
		char yn = TSUtility.readConfirmSelection();
		if (yn == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(id);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}

		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
