/**  
* @文件名 Programmer.java
* @版权 Copyright 2009-2020 
* @描述 Programmer.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午9:59:11
* @修改内容 新增
*/
package com.ccl.team.domain;

import com.ccl.team.service.Status;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午9:59:11
 */
public class Programmer extends Employee {
	private int memberId;
	private Status status;
	private Equipment equipment;
	/**
	 *
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 * @param memberId
	 * @param equipment
	 */
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	/**
	 * 
	 * @author chencl
	 * @date 2020年12月9日 下午2:06:09
	 * @return
	 */ 
	public String getDetailsForTeam() {
		 return getMemberDetails() + "\t程序员";
	}
	
    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }
	
    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription() ;
    }
}
