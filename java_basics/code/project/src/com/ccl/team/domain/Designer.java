/**  
* @文件名 Designer.java
* @版权 Copyright 2009-2020 
* @描述 Designer.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午10:10:14
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午10:10:14
 */
public class Designer extends Programmer {
	
	/**
	 * @Fields bonus : 奖金
	 */ 
	private double bonus;

	/**
	 *
	 * @param id
	 * @param name
	 * @param age
	 * @param salary
	 * @param memberId
	 * @param equipment
	 * @param bonus
	 */
	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary,  equipment);
		this.bonus = bonus;
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	/**
	 * <p>Title getDetailsForTeam</p>
	 * <p>Author chencl</p>
	 * <p>Description </p>
	 * @return
	 * @see com.ccl.team.domain.Programmer#getDetailsForTeam()
	 */
	public String getDetailsForTeam() {
		return getMemberDetails() +"\t设计师\t" + getBonus() ;
	}

	@Override
	public String toString() {
		return getDetails()+ "\t设计师\t"+ getStatus() + "\t" + getBonus() + "\t" +getEquipment().getDescription();
	}

	
	
}
