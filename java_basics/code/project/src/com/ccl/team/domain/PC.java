/**  
* @文件名 PC.java
* @版权 Copyright 2009-2020 
* @描述 PC.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午9:52:58
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午9:52:58
 */
public class PC implements Equipment {

	/**
	 * @Fields model : 机器的型号
	 */ 
	private String model;
	/**
	 * @Fields display : 显示器的名称
	 */ 
	private String display;
	
	
	
	/**
	 *
	 * @param model
	 * @param display
	 */
	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display the display to set
	 */
	public void setDisplay(String display) {
		this.display = display;
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
		return model+display;
	}

}
