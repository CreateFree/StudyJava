/**  
* @文件名 Staus.java
* @版权 Copyright 2009-2020 
* @描述 Staus.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午10:02:10
* @修改内容 新增
*/
package com.ccl.team.service;

/**
 * 
 * @Description 枚举类，封装员工的状态
 * @aothor chencl
 * @date 2020年12月9日上午10:02:10
 */
public class Status {
	private final String NAME;
	private Status(String name) {
		this.NAME = name;
	}
	public static final Status FREE = new Status("FREE");
	public static final Status VOCATION = new Status("VOCATION");
	public static final Status BUSY = new Status("BUSY");
	
	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}

	/**
	 * <p>Title toString</p>
	 * <p>Author chencl</p>
	 * <p>Description </p>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return NAME;
	}
	
	
	
}
