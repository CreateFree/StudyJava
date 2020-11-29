/**  
* @文件名 Account.java
* @版权 Copyright 2009-2020 
* @描述 Account.java
* @修改人 chencl
* @修改时间 2020年11月27日 下午5:04:56
* @修改内容 新增
*/
package com.ccl.supper;

/**
 * 
 * @aothor chencl
 * @date 2020年11月27日下午5:04:56
 */
public class Account {
	private int id; // 账号id
	private double balance; // 余额
	private double annuallnteresRate; // 年利率
	/**
	 *  Account全参数构造器
	 * @param id
	 * @param balance
	 * @param annuallnteresRate
	 */
	public Account(int id, double balance, double annuallnteresRate) {
		this.id = id;
		this.balance = balance;
		this.annuallnteresRate = annuallnteresRate;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the annuallnteresRate
	 */
	public double getAnnuallnteresRate() {
		return annuallnteresRate;
	}
	/**
	 * @param annuallnteresRate the annuallnteresRate to set
	 */
	public void setAnnuallnteresRate(double annuallnteresRate) {
		this.annuallnteresRate = annuallnteresRate;
	}
	
	/**
	 * 返回月利率
	 * @author chencl
	 * @date 2020年11月27日 下午5:08:22
	 * @return
	 */ 
	public double getMonthlyInteres() {
		return getAnnuallnteresRate()/12;
	}
	
	/**
	 *  取款
	 * @author chencl
	 * @date 2020年11月27日 下午5:08:46
	 * @param amount
	 */ 
	public void withdraw (double amount) {
		if(amount<0) {
			System.out.println("取款失败！");
			return;
		}
		if((balance-amount)>=0) {
			balance -= amount;
			System.out.println("取款成功！当前余额为："+balance);
		}else {
			System.out.println("余额不足，取款失败！");
		}
	}
	/**
	 *  存款
	 * @author chencl
	 * @date 2020年11月27日 下午5:08:49
	 * @param amount
	 */ 
	public void deposit (double amount) {
		if(amount<0) {
			System.out.println("存款失败！");
			return;
		}
		balance+=amount;
		System.out.println("存款成功！当前余额为："+ balance);
	}
	
}
