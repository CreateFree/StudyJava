/**  
* @文件名 Architect.java
* @版权 Copyright 2009-2020 
* @描述 Architect.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午10:12:30
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午10:12:30
 */
public class Architect extends Designer {
	/**
	 * @Fields stock : 公司奖励的股票数量
	 */
	private int stock;

	/**
	 *
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 * @param memberId
	 * @param equipment
	 * @param bonus
	 * @param stock
	 */
	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDetailsForTeam() {
		return getMemberDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
	}

	@Override
	public String toString() {
		return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t"
				+ getEquipment().getDescription();
	}

}
