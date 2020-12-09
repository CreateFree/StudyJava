/**  
* @文件名 TeamSerivce.java
* @版权 Copyright 2009-2020 
* @描述 TeamSerivce.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午11:22:07
* @修改内容 新增
*/
package com.ccl.team.service;

import com.ccl.team.domain.Architect;
import com.ccl.team.domain.Designer;
import com.ccl.team.domain.Employee;
import com.ccl.team.domain.Programmer;

/**
 * 
 * @description： 关于开发团队成员的管理：添加、删除等
 * @aothor chencl
 * @date 2020年12月9日上午11:22:07
 */
public class TeamService {
	/**
	 * @Fields conuter : 用来为开发团队新增成员自动生成团队中的唯一ID 应使用增1的方式
	 */
	private static int counter = 1;
	/**
	 * @Fields MAX_MEMBER : 表示开发团队最大成员数
	 */
	private final int MAX_MEMBER = 5;
	/**
	 * @Fields team : 用来保存当前团队中的各成员对象
	 */
	private Programmer[] team = new Programmer[MAX_MEMBER];
	/**
	 * @Fields total : 记录团队成员的实际人数
	 */
	private int total = 0;

	/**
	 * 
	 * @description： 返回当前团队的所有对象
	 * @author chencl
	 * @date 2020年12月9日 上午11:26:32
	 * @return 包含所有成员对象的数组，数组大小与成员人数一致
	 */
	public Programmer[] getTeam() {
		Programmer[] t = new Programmer[total];
		for (int i = 0; i < total; i++) {
			t[i] = team[i];
		}
		return t;
	}

	/**
	 * 
	 * @description： 向团队中添加成员。
	 * @author chencl
	 * @date 2020年12月9日 上午11:26:35
	 * @param e 待添加成员的对象
	 * @throws TeamException 添加失败， TeamException中包含了失败原因
	 */
	public void addMember(Employee e) throws TeamException {
		if (total >= MAX_MEMBER) {
			throw new TeamException("超出团队成员最大数，无法添加！");
		}
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加！");
		}

		Programmer p = (Programmer) e;
		if (isExist(p)) {
			throw new TeamException("该成员已经在该团队，无法添加！");
		}
		
		if(p.getStatus() == Status.BUSY) {
			throw new TeamException("该成员已经在其他团队，无法添加！");
		}else if (p.getStatus() == Status.VOCATION) {
			throw new TeamException("该成员正在休假，无法添加！");
		}
		
		int numArch = 0, numDesi = 0, numProg = 0;
		for(int i =0; i<total;i++) {
			if(team[i] instanceof Architect) {
				numArch++;
			}else if (team[i] instanceof Designer) {
				numDesi++;
			}else if(team[i] instanceof Programmer) {
				numProg++;
			}
		}
		
        if (p instanceof Architect) {
            if (numArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numDesi >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numProg >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }

        //添加到数组
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;

	}

	/**
	 * 
	 * @description： 从团队中删除成员
	 * @author chencl
	 * @date 2020年12月9日 上午11:26:38
	 * @param memberId 待删除成员的memberId
	 * @throws TeamException 找不到指定memberId的员工，删除失败
	 */
	public void removeMember(int memberId) throws TeamException {
		int n=0;
		for(;n<total;n++) {
			if (team[n].getMemberId() == memberId) {
				team[n].setStatus(Status.FREE);
				break;
			}
		}
		// 如果遍历完了都没有找到，抛出异常
		if (n == total ) {
			throw new TeamException("找不到指定memberId的员工，删除失败！");
		}
		// 后面元素覆盖前面元素
		for (int i = n+1; i < total; i++) {
			team[i-1] = team[i];
		}
		team[--total] = null;

	}

	/**
	 * 
	 * @description： 判断该团队是否存在该成员
	 * @author chencl
	 * @date 2020年12月9日 下午3:07:38
	 * @param p
	 * @return
	 */
	private boolean isExist(Programmer p) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == p.getId())
				return true;
		}
		return false;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

}
