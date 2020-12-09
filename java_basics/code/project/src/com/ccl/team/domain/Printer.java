/**  
* @文件名 Printer.java
* @版权 Copyright 2009-2020 
* @描述 Printer.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午9:54:58
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午9:54:58
 */
public class Printer implements Equipment {
	
	/**
	 * @Fields name : 打印机名称 
	 */ 
	private String name;
	/**
	 * @Fields type :  打印机类型
	 */ 
	private String type;

	
	/**
	 *
	 * @param name
	 * @param type
	 */
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * <p>Title getDescription</p>
	 * <p>Author chencl</p>
	 * <p>Description </p>
	 * @return
	 * @see com.ccl.team.domain.Equipment#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}
