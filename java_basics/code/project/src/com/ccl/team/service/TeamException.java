/**  
* @文件名 TeamException.java
* @版权 Copyright 2009-2020 
* @描述 TeamException.java
* @修改人 chencl
* @修改时间 2020年12月9日 上午11:16:30
* @修改内容 新增
*/
package com.ccl.team.service;

/**
 * 
 * @Description 自定义异常类
 * @aothor chencl
 * @date 2020年12月9日上午11:16:30
 */
public class TeamException  extends Exception{
	public static final long servicesID = 646514873134L;
	
	
	public TeamException() {
		
	}
	public TeamException(String msg) {
		super(msg);
	}
}
