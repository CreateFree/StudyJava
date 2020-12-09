/**  
* @文件名 NoteBook.java
* @版权 Copyright 2009-2020 
* @描述 NoteBook.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午9:50:50
* @修改内容 新增
*/
package com.ccl.team.domain;

/**
 * 
 * @aothor chencl
 * @date 2020年12月9日上午9:50:50
 */
public class NoteBook implements Equipment {
	/**
	 * @Fields model : 机器的型号
	 */ 
	private String model;
	/**
	 * @Fields price : 价格
	 */ 
	private double price;

	/**
	 *
	 * @param model
	 * @param price
	 */
	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
		return model+price;
	}

}
